// Overview & Documentation

// The Task2 program is a simple receipt calculator that allows users to input items, calculate the subtotal, tax, and discount, and display the final receipt.

// Classes

// Receipt
// Description: The Receipt class represents a receipt and contains methods to calculate the subtotal, tax, and discount.
// Fields:
// items: a list of Item objects representing the items on the receipt.
// subtotal: the subtotal of the receipt.
// tax: the tax amount of the receipt.
// discount: the discount amount of the receipt.
// Methods:
// addItem(Item item): adds an item to the receipt.
// calculateSubtotal(): calculates the subtotal of the receipt.
// calculateTax(double taxRate): calculates the tax amount of the receipt based on the given tax rate.
// calculateDiscount(double discountRate): calculates the discount amount of the receipt based on the given discount rate.
// getFinalTotal(): returns the final total of the receipt.
// displayReceipt(): displays the receipt.
// Item
// Description: The Item class represents an item on the receipt and contains fields for the item's name, price, and quantity.
// Fields:
// name: the name of the item.
// price: the price of the item.
// quantity: the quantity of the item.
// Methods:
// getName(): returns the name of the item.
// getPrice(): returns the price of the item.
// getQuantity(): returns the quantity of the item.
// Main Method

// The main method is the entry point of the program. It creates a Receipt object and a Scanner object to read user input. The program then enters a loop where it prompts the user to input items, calculates the subtotal, tax, and discount, and displays the final receipt.

// Usage

// To use the program, simply run it and follow the prompts to input items. When you are finished inputting items, type "done" to calculate and display the final receipt.

// Enter item name, price, and quantity (or 'done' to finish):
// Apple, 1.00, 2
// Enter item name, price, and quantity (or 'done' to finish):
// Banana, 0.50, 3
// Enter item name, price, and quantity (or 'done' to finish):
// done
// Receipt:
// Apple x 2 = $2.00
// Banana x 3 = $1.50
// Subtotal: $3.50
// Tax: $0.28
// Discount: $0.35
// Final Total: $3.43

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Receipt {
    private List<Item> items;
    private double subtotal;
    private double tax;
    private double discount;

    public Receipt() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void calculateSubtotal() {
        subtotal = 0;
        for (Item item : items) {
            subtotal += item.getPrice() * item.getQuantity();
        }
    }

    public void calculateTax(double taxRate) {
        tax = subtotal * taxRate / 100;
    }

    public void calculateDiscount(double discountRate) {
        discount = subtotal * discountRate / 100;
    }

    public double getFinalTotal() {
        return subtotal + tax - discount;
    }

    public void displayReceipt() {
        System.out.println("Receipt:");
        for (Item item : items) {
            System.out.println(
                    item.getName() + " x " + item.getQuantity() + " = $" + item.getPrice() * item.getQuantity());
        }
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Tax: $" + tax);
        System.out.println("Discount: $" + discount);
        System.out.println("Final Total: $" + getFinalTotal());
    }
}

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter item name, price, and quantity (or 'done' to finish):");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            String[] parts = input.split(",");
            if (parts.length != 3) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            String name = parts[0].trim();
            double price = Double.parseDouble(parts[1].trim());
            int quantity = Integer.parseInt(parts[2].trim());
            receipt.addItem(new Item(name, price, quantity));
        }

        receipt.calculateSubtotal();
        receipt.calculateTax(8); // 8% tax rate
        receipt.calculateDiscount(10); // 10% discount rate
        receipt.displayReceipt();
    }
}