package design.splitwise.model;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.dto.UserAmount;
import design.splitwise.resolver.EqualSplitResolver;
import design.splitwise.resolver.ExactSplitResolver;
import design.splitwise.resolver.Resolver;

public class ExactSplitDetail extends SplitDetail{
    private List<UserAmount> userAmounts;

    public void add(UserAmount userAmount) {
        this.userAmounts.add(userAmount);
    }

    @Override
    public List<User> getSplitParticipants() {
        return this.userAmounts.stream().map(userAmount -> userAmount.user).toList();
    }

    public List<UserAmount> getUserAmounts() {
        return new ArrayList<>(userAmounts);
    }

    @Override
    public Resolver getResolver() {
        return new ExactSplitResolver();
    }
}
