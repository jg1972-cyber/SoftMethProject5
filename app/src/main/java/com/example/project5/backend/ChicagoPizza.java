package com.example.project5.backend;

/**
 * Factory class that creates Chicago-style pizzas.
 * This implementation of {@link PizzaFactory} produces pizzas
 * with Chicago-specific crust styles and configurations.
 * Each pizza type is created with its appropriate crust.
 */
public class ChicagoPizza implements PizzaFactory{

    /**
     * Creates a Deluxe pizza with Chicago deep dish crust.
     *
     * @return a Deluxe pizza with DEEP_DISH crust
     */
    @Override
    public Pizza createDeluxe() {
        Pizza pizza = new Deluxe();
        pizza.setCrust(Crust.DEEP_DISH);
        return pizza;
    }

    /**
     * Creates a Meatzza pizza with Chicago stuffed crust.
     *
     * @return a Meatzza pizza with STUFFED crust
     */
    @Override
    public Pizza createMeatzza() {
        Pizza pizza = new Meatzza();
        pizza.setCrust(Crust.STUFFED);
        return pizza;
    }

    /**
     * Creates a BBQ Chicken pizza with Chicago pan crust.
     *
     * @return a BBQChicken pizza with PAN crust
     */
    @Override
    public Pizza createBBQChicken() {
        Pizza pizza = new BBQChicken();
        pizza.setCrust(Crust.PAN);
        return pizza;
    }

    /**
     * Creates a Build Your Own pizza with Chicago pan crust.
     *
     * @return a BuildYourOwn pizza with PAN crust
     */
    @Override
    public Pizza createBuildYourOwn() {
        Pizza pizza = new BuildYourOwn();
        pizza.setCrust(Crust.PAN);
        return pizza;
    }
}
