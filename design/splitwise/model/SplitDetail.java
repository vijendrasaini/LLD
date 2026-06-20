package design.splitwise.model;

import java.util.ArrayList;
import java.util.List;

import design.splitwise.enums.SplitType;

public class SplitDetail {
    private List<Split> splits;
    private SplitType splitType;
    public SplitDetail(SplitType splitType) {
        this.splitType = splitType;
        this.splits = new ArrayList<>();
    }

    public void addSplit(Split split) {
        this.splits.add(split);
    }

    public SplitType getSplitType() {
        return splitType;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public List<User> getSplitParticipants() {
        return this.splits.stream().map(split -> split.getUser()).toList();
    }
}
