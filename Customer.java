public class Customer{
    private double balance;
    private final Cart cart;

    public Customer(double balance) {
        this.balance = balance;
        this.cart = new Cart();
    }

    public double getBalance() {
        return balance;
    }

    public Cart getCart() {
        return cart;
    }

    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}