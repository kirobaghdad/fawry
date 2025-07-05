import java.time.LocalDate;

public class Main {
    
    
    public static void main(String[] args)
    {
        Customer customer = new Customer(1000.0);
        ShippableNonPerishableProduct tv = new ShippableNonPerishableProduct("TV", 50.0, 5, 1500);
        ShippableNonPerishableProduct mobile = new ShippableNonPerishableProduct("Mobile", 20.0, 5, 500);
        ShippablePerishableProduct cheese = new ShippablePerishableProduct("Cheese", 5.0, 10, LocalDate.of(2025, 12, 25), 1000);

        NonShippableProduct scratchCard = new NonShippableProduct("Scratch Card", 10.0, 1);

        customer.getCart().addItem(tv, 3);
        customer.getCart().addItem(mobile, 2);
        customer.getCart().addItem(cheese, 2);
        customer.getCart().addItem(scratchCard, 1);

        CheckoutService checkoutService = new CheckoutService();
        
        checkoutService.checkout(customer);
    }

    
}
