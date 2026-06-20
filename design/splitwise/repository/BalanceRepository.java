package design.splitwise.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import design.splitwise.model.Balance;
import design.splitwise.model.Group;
import design.splitwise.model.User;

public class BalanceRepository implements Repository<Balance> {
    Map<Integer, Balance> balances;
    private static int counter = 0;

    public BalanceRepository() {
        this.balances = new HashMap<>();
    }

    @Override
    public int add(Balance t) {
        int id = ++counter;
        t.setId(id);
        this.balances.put(id, t);
        return id;
    }

    @Override
    public Balance getById(int i) {
        return this.balances.get(i);
    }

    @Override
    public List<Balance> getAll() {
        return new ArrayList<>(this.balances.values());
    }

    @Override
    public void delete(int id) {
        this.balances.remove(id);
    }

    @Override
    public void updateById(int id, Balance data) {
        this.balances.put(id, data);
    }

    public Optional<Balance> getBalanceEntryForUsers(User creditor, User debtor, Group group) {
        return this.balances.values().stream()
                .filter(balance -> balance.getGroup().equals(group))
                .filter(balance -> balance.getCreditor().equals(creditor) && balance.getDebtor().equals(debtor) ||
                        balance.getDebtor().equals(creditor) && balance.getCreditor().equals(debtor))
                .findFirst();
    }

    public List<Balance> getCreditBalances(User user, Group group) {
        return this.balances.values().stream()
        .filter(balance -> balance.getGroup().equals(group))
        .filter(balance -> balance.getCreditor().equals(user))
        .toList();
    }

    public List<Balance> getDebtBalances(User user, Group group) {
        return this.balances.values().stream()
        .filter(balance -> balance.getGroup().equals(group))
        .filter(balance -> balance.getDebtor().equals(user))
        .toList();
    }
}
