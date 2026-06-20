package design.splitwise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import design.splitwise.ResolverFactory;
import design.splitwise.dto.BalanceSummary;
import design.splitwise.dto.ResolvedShare;
import design.splitwise.dto.UserAmount;
import design.splitwise.model.Balance;
import design.splitwise.model.Expense;
import design.splitwise.model.Group;
import design.splitwise.model.SplitDetail;
import design.splitwise.model.User;
import design.splitwise.repository.BalanceRepository;
import design.splitwise.repository.ExpenseRepository;
import design.splitwise.resolver.Resolver;

public class BalanceService {
    private ExpenseRepository expenseRepository;
    private ResolverFactory resolverFactory;
    private BalanceRepository balanceRepository;

    public BalanceService(ExpenseRepository expenseRepository, ResolverFactory resolverFactory,
            BalanceRepository balanceRepository) {
        this.expenseRepository = expenseRepository;
        this.resolverFactory = resolverFactory;
        this.balanceRepository = balanceRepository;
    }

    // double getExpenseData(User forUser, Group group) {
    //     List<Expense> expensesByGroupId = expenseRepository.getExpensesByGroupId(group.getId());

    //     for (Expense expense : expensesByGroupId) {
    //         SplitDetail splitDetail = expense.getSplitDetail();
    //     }

    //     return 0;
    // }

    // public List<Expense> getParticpiatedExpenses(User user, Group group) {
    //     // Get total wherever user participated as a participant or as a payer
    //     List<Expense> expensesByGroupId = expenseRepository.getExpensesByGroupId(group.getId());
    //     return expensesByGroupId.stream()
    //             .filter(expense -> expense.getPaidBy().equals(user)
    //                     || expense.getSplitDetail().getSplitParticipants().contains(user))
    //             .toList();
    // }

    // public double getTotalPaidByUser(User user, Group group) {
    //     return this.getParticpiatedExpenses(user, group).stream()
    //             .filter(expense -> expense.getPaidBy().equals(user))
    //             .reduce(0.0, (partialSum, expense) -> partialSum + expense.getAmount(), Double::sum);
    // }

    // public double getGroupTotalForUser(User user, Group group) {
    //     return this.getParticpiatedExpenses(user, group).stream()
    //             .reduce(0.0, (partialSum, expense) -> partialSum + expense.getAmount(), Double::sum);
    // }

    public BalanceSummary getBalance(User user, Group group) {
        List<Balance> creditBalances = balanceRepository.getCreditBalances(user, group);
        List<Balance> debtBalances = balanceRepository.getDebtBalances(user, group);

        double netBalance = creditBalances.stream().mapToDouble(Balance::getAmount).sum()
                - debtBalances.stream().mapToDouble(Balance::getAmount).sum();

        List<UserAmount> creditAmounts = creditBalances.stream()
                .map(balance -> new UserAmount(balance.getDebtor(), balance.getAmount())).toList();
        List<UserAmount> debitAmounts = debtBalances.stream()
                .map(balance -> new UserAmount(balance.getCreditor(), balance.getAmount())).toList();
        List<UserAmount> userAmounts = Stream.concat(creditAmounts.stream(), debitAmounts.stream()).toList();

        return new BalanceSummary(netBalance, userAmounts);
    }

    public void updateBlance(Expense expense) {
        Resolver resolver = expense.getSplitDetail().getResolver();
        List<ResolvedShare> resolvedShares = resolver.resolve(expense);

        for (ResolvedShare resolvedShare : resolvedShares) {
            User creditor = expense.getPaidBy();
            User debtor = resolvedShare.user;
            double amount = resolvedShare.amount;

            // find the balance is alreay exist than update other wise insert
            Optional<Balance> balanceEntryForUsers = balanceRepository.getBalanceEntryForUsers(creditor, debtor,
                    expense.getGroup());
            if (balanceEntryForUsers.isPresent()) {
                Balance balance = balanceEntryForUsers.get();

                if (balance.getCreditor().equals(creditor)) {
                    balance.setAmount(balance.getAmount() + amount);
                } else {
                    // 1 A B 100 => A has to received 100 from B
                    // now might b 3 cases.
                    // 1. B is paying 100
                    if (amount == balance.getAmount()) {
                        // remove the entry or mark the balance as zero. for now updating it to zero
                        balance.setAmount(0);
                    } else if (amount > balance.getAmount()) {
                        // 2. B is paying more than 100
                        // now B will be net creditor
                        balance.setAmount(amount - balance.getAmount());

                        // swaping the users
                        User tempUser = balance.getCreditor();
                        balance.setCreditor(balance.getDebtor());
                        balance.setDebtor(tempUser);
                    } else {
                        // 3. B is paying less than 100
                        // Creditor is still a creditor
                        // just updateing the balance
                        balance.setAmount(balance.getAmount() - amount);
                    }

                }

                balanceRepository.updateById(balance.getId(), balance);
            } else {
                balanceRepository.add(new Balance(expense.getGroup(), creditor, debtor, amount));
            }

        }
    }
}
