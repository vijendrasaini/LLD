package design.splitwise.model;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.resolver.EqualSplitResolver;
import design.splitwise.resolver.Resolver;

public class EqualSplitDetail extends SplitDetail{
    private List<User> participantUsers;
    public EqualSplitDetail(List<User> participantUsers) {
        this.participantUsers = new ArrayList<>(participantUsers);
    }

    @Override
    public List<User> getSplitParticipants() {
        return this.participantUsers;
    }

    @Override
    public Resolver getResolver() {
        return new EqualSplitResolver();
    }
}
