package design.splitwise.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    Map<Integer, Transaction> transactions;
    private static int counter = 0;

    public Repository() {
        this.transactions = new HashMap<>();
    }

    public void add(Transaction transaction) {
        this.transactions.put(++counter, transaction);
    }

    public Transaction get(int transId) {
        if(this.transactions.get(transId) == null) {
            throw new RuntimeException("Transaction not found for ID : " + transId);
        }
        
        return this.transactions.get(transId);
    }

    public List<Transaction> getforGroup(int groupId) {
        return this.transactions.values().stream()
                .filter(transaction -> transaction.getGroupId() == groupId)
                .toList();
    }

    public void update(int transId, Transaction transaction) {
        if(this.transactions.get(transId) == null) {
            throw new RuntimeException("Transaction not found for ID : " + transId);
        }

        this.transactions.put(transId, transaction);
    }
}
