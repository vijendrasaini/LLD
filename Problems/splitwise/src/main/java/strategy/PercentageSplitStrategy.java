package strategy;

import model.Group;
import model.Split;
import model.User;
import model.split.PercentageSplit;

import java.util.HashMap;
import java.util.Map;

public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> calculateSplitAmounts(Split split, Group group) {

        PercentageSplit fixedSplit = (PercentageSplit) split;
        Map<User, Double> map = new HashMap<>();
        for(Map.Entry<User, Double> entry: fixedSplit.getMap().entrySet()) {
            map.put(entry.getKey(), entry.getValue() * split.getAmount() / 100);
        }

        return map;
    }

    @Override
    public boolean validateSplit(Split split) {
        return true; // I can write it later;
    }
}
