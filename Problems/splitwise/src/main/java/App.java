import factory.SplitStrategyFactory;
import model.Group;
import model.Split;
import model.User;
import model.split.EqualSplit;
import model.split.FixedSplit;
import model.split.PercentageSplit;
import service.BalanceManager;
import service.ExpenseManager;

import java.util.HashMap;
import java.util.Map;

public class App {
    static void main(String[] args) {
        test();
    }

    private static void test() {
        BalanceManager bm = new BalanceManager();
        ExpenseManager em = new ExpenseManager(bm);

        User user1 = new User(1, "User A");
        User user2 = new User(2, "User B");

        Group group = new Group(1, "Sharing room");
        group.addUser(user1);
        group.addUser(user2);

        Map<User, Double> expense1 = new HashMap<>();
        expense1.put(user2, 75.00);
        Split split1 = new FixedSplit(user1, 100, expense1);
        em.addSplit(split1, group);
        bm.printBalanceReport(user1, group);
        bm.printBalanceReport(user2, group);


        /*Split split2 = new EqualSplit(user1, 200);
        em.addSplit(split2, group);

        Map<User, Double> expense3 = new HashMap<>();
        expense3.put(user2, 40.00);
        Split split3 = new FixedSplit(user2, 80, expense3);
        em.addSplit(split3, group);*/


    }
}


