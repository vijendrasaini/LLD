package model.split;

import enums.SplitType;
import model.Split;
import model.User;

import java.util.Map;

public class FixedSplit extends Split {
    private Map<User, Double> map;


    public FixedSplit(User user, double amount, Map<User, Double> map) {
        super(user, amount, SplitType.FIXED);
        this.map = map;
    }

    public Map<User, Double> getMap() {
        return map;
    }
}
