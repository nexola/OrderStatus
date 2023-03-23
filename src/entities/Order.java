package entities;

import entities.enums.OrderStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static final DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("(dd/MM/yyyy)");
    private static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private Client client;
    private final LocalDateTime moment = LocalDateTime.now();
    private OrderStatus status;
    private final List<OrderItem> orderItems = new ArrayList<>();

    // Constructors
    public Order() {}

    public Order(Client client, OrderStatus status) {
        this.client = client;
        this.status = status;
    }

    // Getters and Setters
    public LocalDateTime getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // Add and remove itens from list
    public void addItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void removeItem(OrderItem orderItem) {
        orderItems.remove(orderItem);
    }

    // Total price sum
    public Double total() {
        Double sum = 0D;
        for (OrderItem orderItem : orderItems) {
            for (int j = 0; j < orderItem.getSubTotal().size(); j++) {
                sum += orderItem.getSubTotal().get(j);
            }
        }
        return sum;
    }

    // String builder
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:").append("\n").append("Order moment: ");
        sb.append(moment.format(dtf2)).append("\n");
        sb.append("Order status: ").append(status).append("\n");
        sb.append("Client: ").append(client.getName()).append(" ").append(client.getBirthDate().format(dtf1));
        sb.append(" - ").append(client.getEmail()).append("\n");
        sb.append("Order items: ");
        for (OrderItem item : orderItems) {
            sb.append("\n").append(item);
        }
        sb.append("Total price: $").append(total());
        return sb.toString();
    }
}
