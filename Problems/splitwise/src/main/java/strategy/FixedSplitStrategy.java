package strategy;

import model.Group;
import model.Split;
import model.User;
import model.split.FixedSplit;

import java.util.HashMap;
import java.util.Map;

public class FixedSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> calculateSplitAmounts(Split split, Group group) {
        FixedSplit fixedSplit = (FixedSplit) split;
        return new HashMap<>(fixedSplit.getMap());
    }

    @Override
    public boolean validateSplit(Split split) {
        if(split.getAmount() <= 0) return false;

        FixedSplit fixedSplit = (FixedSplit) split;
        double total = 0;
        for(Map.Entry<User, Double> entry: fixedSplit.getMap().entrySet()) {
            if(entry.getValue() <= 0) return false;
            total += entry.getValue();
        }

        return !(split.getAmount() < total);
    }
}
