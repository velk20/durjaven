package test;

import java.util.List;

/**
 * Create a program in a language of your choice (C++, C#, Java, PHP)
 * to input information about product sales.
 * Each sale is specified by a sale ID, product name, quantity sold, and sale price.
 * Display a list of all sales where the quantity sold is greater than 10.
 * Calculate and display the total revenue from all sales.
 */
record Sale(String id, String name, int quantity, double price) { }
public class Main {
    public static void main(String[] args) {
        List<Sale> list = List.of(
                new Sale("1", "1", 231, 321312),
                new Sale("2", "2", 21, 213));

        System.out.println("Qunatiit > 10: " + list.stream().filter(s -> s.quantity() > 10).toList());

        System.out.println("Total revenue: "+list.stream().mapToDouble(Sale::price).sum());
    }
}
