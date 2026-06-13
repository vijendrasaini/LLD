package design.vending.fnbv2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import design.vending.fnbv2.enums.MachineStatus;
import design.vending.fnbv2.state.MachineState;

public class MachineStateFactory {

    private final Map<MachineStatus, MachineState> cache = new HashMap<>();
    private final Map<MachineStatus, Supplier<MachineState>> creators = new HashMap<>();

    public void register(MachineStatus status, Supplier<MachineState> creator) {
        creators.put(status, creator);
    }

    public MachineState getMachineState(MachineStatus status) {
        Supplier<MachineState> creator = creators.get(status);

        if (creator == null) {
            throw new IllegalArgumentException("No state registered for: " + status);
        }

        return cache.computeIfAbsent(status, s -> creator.get());
    }

}