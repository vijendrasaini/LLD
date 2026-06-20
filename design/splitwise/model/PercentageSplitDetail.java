package design.splitwise.model;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.dto.UserPercentage;
import design.splitwise.resolver.PercentageResolver;
import design.splitwise.resolver.Resolver;

public class PercentageSplitDetail extends SplitDetail{
    private List<UserPercentage> userPercentages;
    public PercentageSplitDetail(List<UserPercentage> userPercentages) {
        this.userPercentages = new ArrayList<>(userPercentages);
    }

    @Override
    public List<User> getSplitParticipants() {
        return this.userPercentages.stream().map(userAmount -> userAmount.user).toList();
    }

    public List<UserPercentage> getUserPercentages() {
        return new ArrayList<>(this.userPercentages);
    }

    @Override
    public Resolver getResolver() {
        return new PercentageResolver();
    }
}