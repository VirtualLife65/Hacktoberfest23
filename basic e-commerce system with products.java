import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product ID: " + id + ", Name: " + name + ", Price: $" + price;
    }
}

class Customer {
    private int customerId;
    private String name;
    private List<Product> shoppingCart = new ArrayList<>();

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void addToCart(Product product) {
        shoppingCart.add(product);
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }
}

class Order {
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Laptop", 799.99);
        Product product2 = new Product(2, "Smartphone", 399.99);

        Customer customer1 = new Customer(101, "Alice");
        Customer customer2 = new Customer(102, "Bob");

        customer1.addToCart(product1);
        customer2.addToCart(product2);

        List<Product> customer1Cart = customer1.getShoppingCart();
        List<Product> customer2Cart = customer2.getShoppingCart();

        displayCartContents(customer1, customer1Cart);
        displayCartContents(customer2, customer2Cart);

        // Process orders
        Order order1 = new Order(customer1, customer1Cart);
        Order order2 = new Order(customer2, customer2Cart);

        double total1 = order1.calculateTotal();
        double total2 = order2.calculateTotal();

        System.out.println("\nOrder Summary:");
        System.out.println("Order for " + customer1.getName() + ": Total = $" + total1);
        System.out.println("Order for " + customer2.getName() + ": Total = $" + total2);
    }

    public static void displayCartContents(Customer customer, List<Product> cart) {
        System.out.println("Shopping Cart Contents for " + customer.getName() + ":");
        for (Product product : cart) {
            System.out.println(product);
        }
    }
}
