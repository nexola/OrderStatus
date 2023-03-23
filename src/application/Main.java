package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Init Scanner
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // User data collector
        System.out.println("Enter client data");
        System.out.print(" Name: ");
        String name = sc.next();
        System.out.print(" Email: ");
        String email = sc.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(sc.next(), dtf);
        Client client = new Client(name, email, birthDate);
        OrderItem orderItem = new OrderItem();

        // Adding items to order
        System.out.print("How many items to this order? ");
        int items = sc.nextInt();

        // Item data collector and instancing object (Product)
        for (int i = 0; i < items; i++) {
            System.out.printf("Enter #%d item data:\n", i+1);
            System.out.print("Product name: ");
            String productName = sc.next();
            System.out.print("Product price: $");
            Double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int quantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            orderItem.addProduct(product);
            orderItem.addQuantity(quantity);
        }
        // Instancing object order with the order status value
        Order order = new Order(client, OrderStatus.valueOf("PROCESSING"));
        order.addItem(orderItem);

        // Visual output
        System.out.println(order);
    }
}
