package strategy;

import model.Group;
import model.Split;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> calculateSplitAmounts(Split split, Group group) {
        Map<User, Double> map = new HashMap<>();
        double amount = split.getAmount() / group.getUsersCount();
        for(User user: group.getUsers()) {
            if(user == split.getUser()) continue;
            map.put(user, amount);
        }

        return map;
    }

    @Override
    public boolean validateSplit(Split split) {
        return !(split.getAmount() <= 0);
    }
}
