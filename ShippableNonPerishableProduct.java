class ShippableNonPerishableProduct extends NonPerishableProduct implements Shippable {
    private final double weight;

    public ShippableNonPerishableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() { return weight; }
}