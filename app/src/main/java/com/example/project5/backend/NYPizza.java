package com.example.project5.backend;

/**
 * Factory class that creates New York-style pizzas.
 * <p>
 * This implementation of {@link PizzaFactory} produces pizzas
 * with New York-specific crust styles such as Brooklyn, Thin,
 * and Hand Tossed depending on the pizza type.
 * </p>
 */
public class NYPizza implements PizzaFactory {

    /**
     * Creates a Deluxe pizza with New York Brooklyn crust.
     *
     * @return a Deluxe pizza with BROOKLYN crust
     */
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.BROOKLYN);
        return pizza;
    }

    /**
     * Creates a Meatzza pizza with Hand Tossed crust.
     *
     * @return a Meatzza pizza with HAND_TOSSED crust
     */
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.HAND_TOSSED);
        return pizza;
    }

    /**
     * Creates a BBQ Chicken pizza with Thin crust.
     *
     * @return a BBQChicken pizza with THIN crust
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.THIN);
        return pizza;
    }

    /**
     * Creates a Build Your Own pizza with Hand Tossed crust.
     *
     * @return a BuildYourOwn pizza with HAND_TOSSED crust
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.HAND_TOSSED);
        return pizza;
    }
}