package strategy;

import model.Group;
import model.Split;
import model.User;

import java.util.Map;

public interface SplitStrategy {
    Map<User, Double> calculateSplitAmounts(Split split, Group group);
    boolean validateSplit(Split split);
}
