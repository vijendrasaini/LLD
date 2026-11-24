package factory;

import enums.SplitType;
import strategy.EqualSplitStrategy;
import strategy.FixedSplitStrategy;
import strategy.PercentageSplitStrategy;
import strategy.SplitStrategy;

public class SplitStrategyFactory {
    public static SplitStrategy get(SplitType splitType) {
        return switch (splitType) {
            case SplitType.EQUAL -> new EqualSplitStrategy();
            case SplitType.PERCENTAGE -> new PercentageSplitStrategy();
            default -> new FixedSplitStrategy();
        };
    }
}
