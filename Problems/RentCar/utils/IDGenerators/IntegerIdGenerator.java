package Problems.RentCar.utils.IDGenerators;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerIdGenerator implements IDGenerator<Integer> {
    private Map<String, AtomicInteger> counters = new HashMap<>();
    private IntegerIdGenerator() {}

    private class Holder {  
        static final IntegerIdGenerator INSTANCE = new IntegerIdGenerator();
    }

    public static IntegerIdGenerator getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public Integer next(String entityName) {
        counters.putIfAbsent(entityName, new AtomicInteger());

        return counters.get(entityName).incrementAndGet();
    }
}
