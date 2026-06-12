package design.vending.fnb.src.model;


public class Slot {
    private int quantity;
    private Product product;

    public Slot(int quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
    }

    public void reduceQuantityByOne() {
        if(this.quantity == 0) {
            throw new RuntimeException("No more quanity left for product:[name=%s] to reduce.".formatted(this.product.getName()));
        }
        
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

    public Product getProduct() {
        return product;
    }
}
