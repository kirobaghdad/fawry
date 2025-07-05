import java.time.LocalDate;

public class PerishableProduct extends Product{
    private final LocalDate expirationDate;

    public PerishableProduct(String name, double price, int quantity, LocalDate expirationDate)
    {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean isExpired()
    {
        return LocalDate.now().isAfter(expirationDate);
    }

    public LocalDate getExpirationDate() { return expirationDate; }
}
