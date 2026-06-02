package Problems.RentCar.Models;

import Problems.RentCar.utils.IDGenerators.IntegerIdGenerator;

public abstract class Model {
    private int id;
    protected Model(String entityName) {
        this.id = IntegerIdGenerator.getInstance().next(entityName);
    }

    public int id() {
        return id;
    }
    
}
