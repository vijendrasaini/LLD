package design.splitwise.resolver;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.dto.ResolvedShare;
import design.splitwise.dto.UserAmount;
import design.splitwise.model.ExactSplitDetail;
import design.splitwise.model.Expense;

public class ExactSplitResolver implements Resolver{

    @Override
    public List<ResolvedShare> resolve(Expense expense) {
        ExactSplitDetail splitDetail = (ExactSplitDetail) expense.getSplitDetail();

        List<ResolvedShare> resolvedShares = new ArrayList<>();
        for (UserAmount userAmount : splitDetail.getUserAmounts()) {
            resolvedShares.add(new ResolvedShare(userAmount.user, userAmount.amount));
        }

        return resolvedShares;
    }
}
