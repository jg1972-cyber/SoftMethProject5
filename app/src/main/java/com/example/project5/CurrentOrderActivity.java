package com.example.project5;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project5.backend.Order;
import com.example.project5.backend.Pizza;

public class CurrentOrderActivity extends AppCompatActivity {

    private ListView currentOrderList;
    private TextView orderNumberText, numPizzasText, subtotalText, taxText, totalText;
    private Button removePizzaButton, clearOrderButton, placeOrderButton, backButton;

    private ArrayAdapter<Pizza> pizzaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_order);

        currentOrderList = findViewById(R.id.currentOrderList);
        orderNumberText = findViewById(R.id.orderNumberText);
        numPizzasText = findViewById(R.id.numPizzasText);
        subtotalText = findViewById(R.id.subtotalText);
        taxText = findViewById(R.id.taxText);
        totalText = findViewById(R.id.totalText);

        removePizzaButton = findViewById(R.id.removePizzaButton);
        clearOrderButton = findViewById(R.id.clearOrderButton);
        placeOrderButton = findViewById(R.id.placeOrderButton);
        backButton = findViewById(R.id.backButton);

        pizzaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice);
        currentOrderList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        currentOrderList.setAdapter(pizzaAdapter);

        removePizzaButton.setOnClickListener(v -> removePizza());
        clearOrderButton.setOnClickListener(v -> clearOrder());
        placeOrderButton.setOnClickListener(v -> placeOrder());
        backButton.setOnClickListener(v -> finish());

        refreshView();
    }

    private void refreshView() {
        Order currentOrder = AppSingleton.getInstance().getCurrentOrder();

        pizzaAdapter.clear();
        pizzaAdapter.addAll(currentOrder.getPizzas());
        pizzaAdapter.notifyDataSetChanged();

        orderNumberText.setText(String.valueOf(currentOrder.getNumber()));
        numPizzasText.setText(String.valueOf(currentOrder.getPizzas().size()));
        subtotalText.setText("$" + String.format("%.2f", currentOrder.getSubtotal()));
        taxText.setText("$" + String.format("%.2f", currentOrder.getSalesTax()));
        totalText.setText("$" + String.format("%.2f", currentOrder.getTotal()));
    }

    private void removePizza() {
        int position = currentOrderList.getCheckedItemPosition();

        if (position == ListView.INVALID_POSITION) {
            return;
        }

        Pizza selectedPizza = pizzaAdapter.getItem(position);
        AppSingleton.getInstance().getCurrentOrder().removePizza(selectedPizza);

        currentOrderList.clearChoices();
        refreshView();
    }

    private void clearOrder() {
        AppSingleton.getInstance().getCurrentOrder().clear();
        refreshView();
    }

    private void placeOrder() {
        Order currentOrder = AppSingleton.getInstance().getCurrentOrder();

        if (currentOrder.isEmpty()) {
            return;
        }

        AppSingleton.getInstance().getStoreOrders().addOrder(currentOrder);
        AppSingleton.getInstance().resetCurrentOrder();

        refreshView();
    }
}