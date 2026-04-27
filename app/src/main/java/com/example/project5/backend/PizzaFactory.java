package com.example.project5.backend;

/**
 * Factory interface for creating different types of pizzas.
 * Each implementation defines how pizzas are created for a specific style
 * (e.g., Chicago-style or New York-style) by setting appropriate crusts
 * and default configurations.
 */
public interface PizzaFactory {
    Pizza createDeluxe(); //create a Deluxe object and set the toppings/crust
    Pizza createMeatzza();
    Pizza createBBQChicken();
    Pizza createBuildYourOwn();
}
