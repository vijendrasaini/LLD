package model.split;

import enums.SplitType;
import model.Split;
import model.User;

import java.util.Map;

public class PercentageSplit extends Split {
    private Map<User, Double> map;

    public PercentageSplit(User user, double amount, Map<User, Double> map) {
        super(user, amount, SplitType.PERCENTAGE);
        this.map = map;
    }

    public Map<User, Double> getMap() {
        return map;
    }
}
