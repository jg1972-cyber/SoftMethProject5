package com.example.project5.backend;

/**
 * Represents a Meatzza pizza with a fixed meat-heavy topping set.
 * This pizza comes pre-configured with sausage, pepperoni,
 * beef, and ham. The price is determined solely by the size
 * and does not depend on toppings.
 */
public class Meatzza extends Pizza {

    private static final double SMALL_PRICE = 19.99;
    private static final double MEDIUM_PRICE = 21.99;
    private static final double LARGE_PRICE = 23.99;

    /**
     * Constructs a Meatzza pizza with predefined meat toppings.
     */
    public Meatzza() {
        super();
        addTopping(Topping.SAUSAGE);
        addTopping(Topping.PEPPERONI);
        addTopping(Topping.BEEF);
        addTopping(Topping.HAM);
    }

    /**
     * Calculates the price of the Meatzza pizza based on size.
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