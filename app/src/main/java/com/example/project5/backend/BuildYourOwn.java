package com.example.project5.backend;
/**
 * Represents a customizable pizza where the user can choose toppings.
 * The base price depends on the selected size, and each topping adds
 * an additional fixed cost. A maximum number of toppings is enforced.
 */
public class BuildYourOwn extends Pizza {

    private static final double SMALL_BASE = 10.99;
    private static final double MEDIUM_BASE = 12.99;
    private static final double LARGE_BASE = 14.99;
    private static final double TOPPING_PRICE = 1.69;
    private static final int MAX_TOPPINGS = 5;

    /**
     * Constructs a BuildYourOwn pizza with no toppings initially selected.
     */
    public BuildYourOwn() {
        super();
    }

    /**
     * Calculates the total price of the pizza based on size and number of toppings.
     * Base price is determined by size, and each topping adds a fixed cost.
     *
     * @return total price of the pizza
     */
    @Override
    public double price() {
        double base;

        switch (getSize()) {
            case SMALL:
                base = SMALL_BASE;
                break;
            case MEDIUM:
                base = MEDIUM_BASE;
                break;
            case LARGE:
                base = LARGE_BASE;
                break;
            default:
                return 0;
        }

        return base + (getToppings().size() * TOPPING_PRICE);
    }

    /**
     * Adds a topping to the pizza if the maximum number of toppings
     * has not been reached.
     *
     * @param topping the topping to add
     */
    @Override
    public void addTopping(Topping topping) {
        if (getToppings().size() >= MAX_TOPPINGS) {
            return;
        }
        super.addTopping(topping);
    }
}