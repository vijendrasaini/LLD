package design.splitwise.resolver;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.dto.ResolvedShare;
import design.splitwise.model.Expense;
import design.splitwise.model.SplitDetail;
import design.splitwise.model.User;

public class EqualSplitResolver implements Resolver{

    @Override
    public List<ResolvedShare> resolve(Expense expense) {
        double amount = expense.getAmount();
        SplitDetail splitDetail = expense.getSplitDetail();

        List<ResolvedShare> resolvedShares = new ArrayList<>();
        double share = amount / splitDetail.getSplitParticipants().size(); // @todo what if user hasn't provide among whom it's needs to be split. it will cause division by zero exception
        for (User participant : splitDetail.getSplitParticipants()) {
            resolvedShares.add(new ResolvedShare(participant, share));
        }

        return resolvedShares;
    }
}
