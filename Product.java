public abstract class Product {
    private final String name;
    private final double price;
    private int quantity;


    public Product(String name, double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    
    
    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }

    public boolean isAvailable(int requestedQuantity) {
        return requestedQuantity <= quantity;
    }

    public boolean isExpired() {
        return false;
    }
}
