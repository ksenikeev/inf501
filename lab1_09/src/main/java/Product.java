public class Product {
    public String name;
    public double price;
    public Category category;
    public String img;
    public String components;
    public boolean isAvailable;
    public int time;

    public Product(String name, Category category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
}
