package design.splitwise.model;

import java.util.List;

import design.splitwise.resolver.Resolver;

public abstract class SplitDetail {
    public abstract List<User> getSplitParticipants();

    public abstract Resolver getResolver();
}
