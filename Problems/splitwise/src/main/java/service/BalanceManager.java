package service;

import model.Group;
import model.User;

import java.util.Map;

public class BalanceManager {
    public Map<User, Double> getBalance(User user, Group group) {
        return group.getUserBalance(user);
    }

    public void settle(User payer, User receiver, Group group, double amount) {
        Map<User, Double> payerBalance = group.getUserBalance(payer);
        Map<User, Double> receiverBalance = group.getUserBalance(receiver);

        payerBalance.put(receiver, payerBalance.get(receiver) + amount);
        receiverBalance.put(payer, payerBalance.get(receiver) - amount);
    }

    public void printBalanceReport(User user, Group group) {
        Map<User, Double> report = group.getUserBalance(user);
        System.out.printf("===============Balance Report of %s==============%n", user.getName());
        System.out.println("--------Pair Report ---------");
        for (Map.Entry<User, Double> entry: report.entrySet()) {
            System.out.println(entry.getKey() + " Balance : " + entry.getValue());
        }
    }
}
