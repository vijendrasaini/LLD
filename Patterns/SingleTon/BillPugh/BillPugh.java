package Patterns.SingleTon.BillPugh;

public class BillPugh {
    private BillPugh() {}

    private class Holder {
        public static BillPugh INSTANCE = new BillPugh();
    }

    public static BillPugh getInstance() {
        return Holder.INSTANCE;
    }
}
