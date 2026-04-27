package com.example.project5;

public class PizzaOption {
    private String name;
    private boolean chicagoStyle;
    private int imageResource;

    public PizzaOption(String name, boolean chicagoStyle, int imageResource) {
        this.name = name;
        this.chicagoStyle = chicagoStyle;
        this.imageResource = imageResource;
    }

    public String getName() { return name; }
    public boolean isChicagoStyle() { return chicagoStyle; }
    public int getImageResource() { return imageResource; }
}