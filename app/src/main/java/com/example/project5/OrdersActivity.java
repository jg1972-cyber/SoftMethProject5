package com.example.project5;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project5.backend.Order;
import com.example.project5.backend.StoreOrders;

import java.io.IOException;

public class OrdersActivity extends AppCompatActivity {

    private Spinner orderSpinner;
    private TextView orderDetailsText;
    private Button showOrderButton, cancelOrderButton, exportOrdersButton, backButton;

    private ArrayAdapter<Integer> orderNumberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

        orderSpinner = findViewById(R.id.orderSpinner);
        orderDetailsText = findViewById(R.id.orderDetailsText);

        showOrderButton = findViewById(R.id.showOrderButton);
        cancelOrderButton = findViewById(R.id.cancelOrderButton);
        exportOrdersButton = findViewById(R.id.exportOrdersButton);
        backButton = findViewById(R.id.backButton);

        orderNumberAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item);

        orderSpinner.setAdapter(orderNumberAdapter);

        showOrderButton.setOnClickListener(v -> showOrderDetails());
        cancelOrderButton.setOnClickListener(v -> cancelOrder());
        exportOrdersButton.setOnClickListener(v -> exportOrders());
        backButton.setOnClickListener(v -> finish());

        refreshOrders();
    }

    private void refreshOrders() {
        StoreOrders storeOrders = AppSingleton.getInstance().getStoreOrders();

        orderNumberAdapter.clear();
        orderDetailsText.setText("");

        if (storeOrders == null || storeOrders.isEmpty()) {
            orderNumberAdapter.notifyDataSetChanged();
            return;
        }

        for (Order order : storeOrders.getOrders()) {
            orderNumberAdapter.add(order.getNumber());
        }

        orderNumberAdapter.notifyDataSetChanged();
    }

    private void showOrderDetails() {
        StoreOrders storeOrders = AppSingleton.getInstance().getStoreOrders();

        if (storeOrders == null || orderSpinner.getSelectedItem() == null) {
            return;
        }

        int selectedOrderNumber = (int) orderSpinner.getSelectedItem();
        Order selectedOrder = storeOrders.findOrder(selectedOrderNumber);

        if (selectedOrder != null) {
            orderDetailsText.setText(selectedOrder.toString());
        }
    }

    private void cancelOrder() {
        StoreOrders storeOrders = AppSingleton.getInstance().getStoreOrders();

        if (storeOrders == null || orderSpinner.getSelectedItem() == null) {
            return;
        }

        int selectedOrderNumber = (int) orderSpinner.getSelectedItem();
        boolean removed = storeOrders.removeOrder(selectedOrderNumber);

        if (removed) {
            showMessage("Order Canceled", "Order #" + selectedOrderNumber + " was canceled.");
            refreshOrders();
        }
    }

    private void exportOrders() {
        StoreOrders storeOrders = AppSingleton.getInstance().getStoreOrders();

        if (storeOrders == null || storeOrders.isEmpty()) {
            showMessage("No Orders", "There are no orders to export.");
            return;
        }

        try {
            storeOrders.exportOrders("orders.txt");
            showMessage("Export Successful", "Orders exported to orders.txt.");
        } catch (IOException e) {
            showMessage("Export Failed", "Could not export orders.");
        }
    }

    private void showMessage(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}