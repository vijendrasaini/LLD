package design.vending.fnb.src.model;

public class Product {
    private String name;
    private int price;
    private String image; // for now taking it as String

    public Product(String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public void show() {
        System.out.println("Name : " + this.name + ", Price : " + this.price + ", Image : " + this.image);
    }
}
