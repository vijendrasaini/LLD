package model.split;

import enums.SplitType;
import model.Split;
import model.User;

public class EqualSplit extends Split {

    public EqualSplit(User user, double amount) {
        super(user, amount, SplitType.EQUAL);
    }
}
