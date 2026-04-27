package com.example.project5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView pizzaOptionsRecyclerView;
    private Button currentOrderButton;
    private Button ordersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppSingleton.getInstance();

        pizzaOptionsRecyclerView = findViewById(R.id.pizzaOptionsRecyclerView);
        currentOrderButton = findViewById(R.id.currentOrderButton);
        ordersButton = findViewById(R.id.ordersButton);

        setupPizzaOptionsRecyclerView();

        currentOrderButton.setOnClickListener(v ->
                startActivity(new Intent(this, CurrentOrderActivity.class)));

        ordersButton.setOnClickListener(v ->
                startActivity(new Intent(this, OrdersActivity.class)));
    }

    private void setupPizzaOptionsRecyclerView() {
        ArrayList<PizzaOption> options = new ArrayList<>();

        options.add(new PizzaOption("Chicago Deluxe", true, R.drawable.deluxe));
        options.add(new PizzaOption("Chicago BBQ Chicken", true, R.drawable.bbq));
        options.add(new PizzaOption("Chicago Meatzza", true, R.drawable.meatzza));
        options.add(new PizzaOption("Chicago Build Your Own", true, R.drawable.byo));

        options.add(new PizzaOption("NY Deluxe", false, R.drawable.deluxe));
        options.add(new PizzaOption("NY BBQ Chicken", false, R.drawable.bbq));
        options.add(new PizzaOption("NY Meatzza", false, R.drawable.meatzza));
        options.add(new PizzaOption("NY Build Your Own", false, R.drawable.byo));

        PizzaOptionAdapter adapter = new PizzaOptionAdapter(options, option -> {
            Intent intent;

            if (option.isChicagoStyle()) {
                intent = new Intent(this, ChicagoActivity.class);
            } else {
                intent = new Intent(this, NYActivity.class);
            }

            intent.putExtra("pizzaType", option.getName());
            startActivity(intent);
        });

        pizzaOptionsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pizzaOptionsRecyclerView.setAdapter(adapter);
    }
}