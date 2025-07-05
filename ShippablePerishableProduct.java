
import java.time.LocalDate;

public class ShippablePerishableProduct extends PerishableProduct implements Shippable {
    private final double weight;
    
    public ShippablePerishableProduct(String name, double price, int quantity, LocalDate expirationDate, double weight) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
