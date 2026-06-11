package design.vending.fnb.src.model;


public class Slot {
    private int quantity;
    private Product product;

    public Slot(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public void reductQuantityByOne() {
        this.quantity--;
    }

    public void viewSlot() {
        System.out.println("Quantity : " + quantity + ", Product : " + this.product);
    }

    public int getQuantity() {
        return quantity;
    }

    public void showProduct() {
        // ask product to show.
        this.product.show();
    }
}
