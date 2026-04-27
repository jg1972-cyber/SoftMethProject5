package com.example.project5.backend;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a collection of customer orders in a store.
 * Provides functionality to add, remove, search, clear, and export orders.
 */
public class StoreOrders {
    private ArrayList<Order> orders;

    /**
     * Constructs an empty StoreOrders list.
     */
    public StoreOrders() {
        orders = new ArrayList<>();
    }

    /**
     * Returns the list of all orders in the store.
     *
     * @return ArrayList of Order objects
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * Adds a valid order to the store.
     * An order is added only if it is not null and not empty.
     *
     * @param order the Order to add
     */
    public void addOrder(Order order) {
        if (order != null && !order.isEmpty()) {
            orders.add(order);
        }
    }

    /**
     * Removes an order by its order number.
     *
     * @param orderNumber the order number to remove
     * @return true if the order was found and removed, false otherwise
     */
    public boolean removeOrder(int orderNumber) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getNumber() == orderNumber) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Finds and returns an order by its order number.
     *
     * @param orderNumber the order number to search for
     * @return the matching Order if found, otherwise null
     */
    public Order findOrder(int orderNumber) {
        for (Order order : orders) {
            if (order.getNumber() == orderNumber) {
                return order;
            }
        }
        return null;
    }

    /**
     * Checks whether there are no orders in the store.
     *
     * @return true if there are no orders, false otherwise
     */
    public boolean isEmpty() {
        return orders.isEmpty();
    }

    /**
     * Removes all orders from the store.
     */
    public void clear() {
        orders.clear();
    }

    /**
     * Exports all orders to a text file.
     *
     * @param fileName the name of the file to write orders to
     * @throws IOException if an error occurs while writing to the file
     */
    public void exportOrders(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName);

        for (Order order : orders) {
            writer.write(order.toString());
            writer.write("\n\n");
        }

        writer.close();
    }

    /**
     * Returns a formatted string representation of all orders.
     *
     * @return string containing all orders separated by blank lines
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Order order : orders) {
            builder.append(order).append("\n\n");
        }

        return builder.toString();
    }
}