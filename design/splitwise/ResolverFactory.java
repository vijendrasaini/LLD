package design.splitwise;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import design.splitwise.enums.SplitType;
import design.splitwise.resolver.Resolver;

public class ResolverFactory {
    private Map<SplitType, Supplier<Resolver>> supplierMap;
    public ResolverFactory() {
        this.supplierMap = new HashMap<>();
    }

    public void register(SplitType splitType, Supplier<Resolver> supplier) {
        this.supplierMap.put(splitType, supplier);
    }

    public Resolver get(SplitType splitType) {
        if(this.supplierMap.get(splitType) == null) {
            throw new RuntimeException("Registion is not done for type : " + splitType);
        }

        return this.supplierMap.get(splitType).get();
    }
    
}
