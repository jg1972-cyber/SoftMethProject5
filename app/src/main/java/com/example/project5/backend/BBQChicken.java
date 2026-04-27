package com.example.project5.backend;


/**
 * Represents a BBQ Chicken pizza with a fixed set of toppings.
 * This pizza comes pre-configured with BBQ chicken, green pepper,
 * provolone, and cheddar toppings. The price depends on the selected size.
 */
public class BBQChicken extends Pizza {

    private static final double SMALL_PRICE = 16.99;
    private static final double MEDIUM_PRICE = 18.99;
    private static final double LARGE_PRICE = 20.99;
    /**
     * Constructs a BBQChicken pizza with default toppings.
     * The toppings cannot be removed or changed in this implementation.
     */
    public BBQChicken() {
        super();
        addTopping(Topping.BBQ_CHICKEN);
        addTopping(Topping.GREEN_PEPPER);
        addTopping(Topping.PROVOLONE);
        addTopping(Topping.CHEDDAR);
    }
    /**
     * Calculates the price of the BBQ Chicken pizza based on size.
     *
     * @return the price of the pizza depending on its size
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