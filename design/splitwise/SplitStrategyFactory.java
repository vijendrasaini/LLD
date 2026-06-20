package design.splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import design.splitwise.enums.SplitType;
import design.splitwise.strategy.SplitStrategy;

public class SplitStrategyFactory {
    private Map<SplitType, Supplier<SplitStrategy>> supplierMap;
    public SplitStrategyFactory() {
        this.supplierMap = new HashMap<>();
    }

    public void register(SplitType splitType, Supplier<SplitStrategy> supplier) {
        this.supplierMap.put(splitType, supplier);
    }

    public SplitStrategy get(SplitType splitType) {
        return this.supplierMap.get(splitType).get();
    }
}
