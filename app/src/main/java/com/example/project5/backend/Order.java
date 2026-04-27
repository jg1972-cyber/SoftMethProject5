package com.example.project5.backend;

import java.util.ArrayList;

/**
 * Represents a customer order containing multiple pizzas.
 * Each order is assigned a unique order number and maintains
 * a list of pizzas. It supports calculations for subtotal,
 * sales tax, and total cost.
 */
public class Order {
    private static final double NJ_SALES_TAX = 0.06625;
    private static int nextOrderNumber = 1;

    private int number;
    private ArrayList<Pizza> pizzas;

    /**
     * Constructs a new Order with a unique order number.
     */
    public Order() {
        this.number = nextOrderNumber++;
        this.pizzas = new ArrayList<>();
    }

    /**
     * Returns the order number.
     *
     * @return order number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns the list of pizzas in this order.
     *
     * @return list of pizzas
     */
    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    /**
     * Adds a pizza to the order if it is not null.
     *
     * @param pizza the pizza to add
     */
    public void addPizza(Pizza pizza) {
        if (pizza != null) {
            pizzas.add(pizza);
        }
    }

    /**
     * Removes a pizza from the order.
     *
     * @param pizza the pizza to remove
     */
    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    /**
     * Checks if the order has no pizzas.
     *
     * @return true if order is empty, false otherwise
     */
    public boolean isEmpty() {
        return pizzas.isEmpty();
    }

    /**
     * Calculates the subtotal of all pizzas in the order.
     *
     * @return subtotal before tax
     */
    public double getSubtotal() {
        double subtotal = 0;
        for (Pizza pizza : pizzas) {
            subtotal += pizza.price();
        }
        return subtotal;
    }


    /**
     * Clears all pizzas from the order.
     * This method is functionally identical to clearOrder().
     */
    public void clear() {
        pizzas.clear();
    }

    /**
     * Calculates the sales tax for the order (New Jersey rate).
     *
     * @return sales tax amount
     */
    public double getSalesTax() {
        return getSubtotal() * NJ_SALES_TAX;
    }

    /**
     * Calculates the total cost of the order including tax.
     *
     * @return total order cost
     */
    public double getTotal() {
        return getSubtotal() + getSalesTax();
    }

    /**
     * Returns a formatted string representation of the order,
     * including all pizzas and cost breakdown.
     *
     * @return formatted order details
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order #").append(number).append("\n");

        for (Pizza pizza : pizzas) {
            builder.append(pizza).append("\n");
        }

        builder.append("Subtotal: $")
                .append(String.format("%.2f", getSubtotal()))
                .append("\n");

        builder.append("Sales Tax: $")
                .append(String.format("%.2f", getSalesTax()))
                .append("\n");

        builder.append("Order Total: $")
                .append(String.format("%.2f", getTotal()));

        return builder.toString();
    }
}