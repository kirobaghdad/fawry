import java.util.ArrayList;

class CheckoutService {
    private static final double SHIPPING_FEES = 30.0;

    public void checkout(Customer customer) {
        Cart cart = customer.getCart();

        if (cart.isEmpty()) {
            printError("Cart is empty");
            return;
        }

        for (Object[] item : cart.getItems()) {
            Product product = (Product) item[0];
            int quantity = (int) item[1];

            if (product.isExpired()) {
                printError(product.getName() + " is expired");
                return;
            }
            if (!product.isAvailable(quantity)) {
                printError(product.getName() + " is out of stock");
                return;
            }
        }

        double subtotal = cart.calculateSubtotal();
        ArrayList<Shippable> shippableItems = cart.getShippableItems();

        double totalAmount = subtotal + SHIPPING_FEES;

        if (customer.getBalance() < totalAmount) {
            printError("Insufficient balance");
            return;
        }

        ShippingService shippingService = new ShippingService();
        shippingService.ship(shippableItems);

        for (Object[] item : cart.getItems()) {
            Product product = (Product) item[0];
            int quantity = (int) item[1];
            product.reduceQuantity(quantity);
        }

        customer.deductBalance(totalAmount);

        System.out.println("** Checkout receipt **");
        for (Object[] item : cart.getItems()) {
            Product product = (Product) item[0];
            int quantity = (int) item[1];

            System.out.printf("%dx %s \t", quantity, product.getName());
            System.out.printf("%.0f%n", product.getPrice() * quantity);
        }
        System.out.println("----------------------");
        System.out.printf("Subtotal %.0f \t %n", subtotal);
        System.out.printf("Shipping %.0f \t %n", SHIPPING_FEES);
        System.out.printf("Amount %.0f \t %n", totalAmount);
        System.out.printf("Customer balance after payment %.0f \t %n", customer.getBalance());
    }

    private void printError(String message) {
        System.err.println("\u001B[31m" + message + "\u001B[0m");
    }
}