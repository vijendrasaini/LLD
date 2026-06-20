package design.splitwise.resolver;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.dto.ResolvedShare;
import design.splitwise.dto.UserPercentage;
import design.splitwise.model.Expense;
import design.splitwise.model.PercentageSplitDetail;

public class PercentageResolver implements Resolver{

    @Override
    public List<ResolvedShare> resolve(Expense expense) {
        double amount = expense.getAmount();
        PercentageSplitDetail splitDetail = (PercentageSplitDetail) expense.getSplitDetail();

        List<ResolvedShare> resolvedShares = new ArrayList<>();
        for (UserPercentage userPercentage : splitDetail.getUserPercentages()) {
            resolvedShares.add(new ResolvedShare(userPercentage.user, amount * userPercentage.percentage / 100));
        }

        return resolvedShares;
    }
}