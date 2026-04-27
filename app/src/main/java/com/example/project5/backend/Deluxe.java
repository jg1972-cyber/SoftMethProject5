package com.example.project5.backend;

/**
 * Represents a Deluxe pizza with a fixed set of classic toppings.
 * The Deluxe pizza comes pre-loaded with sausage, pepperoni,
 * green pepper, onion, and mushroom. The price depends on size
 * and does not change based on toppings.
 */
public class Deluxe extends Pizza {

    private static final double SMALL_PRICE = 18.99;
    private static final double MEDIUM_PRICE = 20.99;
    private static final double LARGE_PRICE = 22.99;

    /**
     * Constructs a Deluxe pizza with predefined toppings.
     */
    public Deluxe() {
        super();
        addTopping(Topping.SAUSAGE);
        addTopping(Topping.PEPPERONI);
        addTopping(Topping.GREEN_PEPPER);
        addTopping(Topping.ONION);
        addTopping(Topping.MUSHROOM);
    }


    /**
     * Calculates the price of the Deluxe pizza based on its size.
     *
     * @return the fixed price for the selected size
     */
    @Override
    public double price() {
        switch (getSize()) {
            case SMALL: return SMALL_PRICE;
            case MEDIUM: return MEDIUM_PRICE;
            case LARGE: return LARGE_PRICE;
            default: return 0;
        }
    }
}