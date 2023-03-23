package entities;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private final List<Integer> quantity = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final List<Double> subTotal = new ArrayList<>();

    // Constructors
    public OrderItem() {}

    // Getters and Setters
    public List<Integer> getQuantity() {
        return quantity;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void addQuantity(Integer quantity) {
        this.quantity.add(quantity);
    }

    public void removeQuantity(Integer quantity) {
        this.quantity.remove(quantity);
    }

    public List<Double> getSubTotal() {
        return subTotal;
    }

    // Sum the products
    public void subTotalLocal() {
        double sum = 0D;
        for (int i = 0; i < quantity.size(); i++) {
            double subtotal = products.get(i).getPrice() * quantity.get(i);
            subTotal.add(subtotal);
            sum += subtotal;
        }
    }

    // String builder
    public String toString() {
        subTotalLocal();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size(); i++) {
            sb.append(products.get(i).getName()).append(", $").append(products.get(i).getPrice()).append(", ");
            sb.append("Quantity: ").append(quantity.get(i)).append(", ").append("Subtotal: $");
            sb.append(subTotal.get(i)).append("\n");
        }
        return sb.toString();
    }
}
