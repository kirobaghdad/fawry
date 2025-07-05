import java.util.ArrayList;

public class Cart{
    private final ArrayList<Object[]> products;

    public Cart(){
        products = new ArrayList<>();
    }

    public void addItem(Product product, int quantity)
    {
        if (quantity <= 0) {
            System.err.println("\u001B[31mQuantity must be positive\u001B[0m");
            return;
        }
        if (product.isExpired()) {
            System.err.println("\u001B[31m" + product.getName() + " is expired\u001B[0m");
            return;
        }
        if (!product.isAvailable(quantity)) {
            System.err.println("\u001B[31m" + product.getName() + " is out of stock\u001B[0m");
            return;
        }

        products.add(new Object[]{product, quantity});
    }

    public ArrayList<Object[]> getItems()
    {
        return products;
    }

    public boolean isEmpty()
    {
        return products.isEmpty();
    }

    public double calculateSubtotal() {
        return products.stream()
            .mapToDouble(item -> ((Product) item[0]).getPrice() * (int) item[1])
            .sum();
    }

    public ArrayList<Shippable> getShippableItems() {
        ArrayList<Shippable> shippableItems = new ArrayList<>();
        for (Object[] item : products) {
            Product product = (Product) item[0];
            int quantity = (int) item[1];
            if (product instanceof Shippable shippable) {
                for (int i = 0; i < quantity; i++) {
                    shippableItems.add(shippable);
                }
            }
        }
        return shippableItems;
    }
}