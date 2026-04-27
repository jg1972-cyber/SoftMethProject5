package com.example.project5.backend;

import java.util.ArrayList;

/**
 * Abstract base class representing a generic pizza.
 * A pizza has a size, crust type, and a list of toppings.
 * Specific pizza types must implement their own pricing logic.
 * This class provides shared functionality for managing toppings,
 * crust, and size across all pizza types.
 */
public abstract class Pizza {
    private ArrayList<Topping> toppings; //Topping is a enum class
    private Crust crust; //Crust is a enum class
    private Size size; //Size is a enum class

    /**
     * Calculates the price of the pizza.
     *
     * @return the total price of the pizza
     */
    public abstract double price(); //polymorphism

    /**
     * Constructs a Pizza with an empty list of toppings.
     */
    public Pizza() {
        toppings = new ArrayList<>();
    }

    /**
     * Adds a topping to the pizza.
     *
     * @param topping the topping to add
     */
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    /**
     * Removes a topping from the pizza if it exists.
     *
     * @param topping the topping to remove
     */
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    /**
     * Returns the list of toppings on the pizza.
     *
     * @return list of toppings
     */
    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    /**
     * Returns the crust type of the pizza.
     *
     * @return crust type
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * Sets the crust type of the pizza.
     *
     * @param crust the crust to set
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    /**
     * Returns the size of the pizza.
     *
     * @return pizza size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Sets the size of the pizza.
     *
     * @param size the size to set
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     * Returns a formatted string representation of the pizza,
     * including type, crust, toppings, size, and price.
     *
     * @return string representation of the pizza
     */
    @Override
    public String toString() {
        StringBuilder toppingsStr = new StringBuilder();

        for (int i = 0; i < toppings.size(); i++) {
            toppingsStr.append(toppings.get(i));
            if (i < toppings.size() - 1) {
                toppingsStr.append(", ");
            }
        }

        return this.getClass().getSimpleName() +
                " (" + crust + "), " +
                toppingsStr +
                ", " + size +
                ", $" + String.format("%.2f", price());
    }
}