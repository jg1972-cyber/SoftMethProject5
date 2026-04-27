package com.example.project5;

import com.example.project5.backend.Order;
import com.example.project5.backend.StoreOrders;

public class AppSingleton {

    private static AppSingleton instance;

    private Order currentOrder;
    private StoreOrders storeOrders;

    private AppSingleton() {
        currentOrder = new Order();
        storeOrders = new StoreOrders();
    }

    public static AppSingleton getInstance() {
        if (instance == null) {
            instance = new AppSingleton();
        }
        return instance;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public StoreOrders getStoreOrders() {
        return storeOrders;
    }

    public void setStoreOrders(StoreOrders storeOrders) {
        this.storeOrders = storeOrders;
    }

    public void resetCurrentOrder() {
        currentOrder = new Order();
    }
}