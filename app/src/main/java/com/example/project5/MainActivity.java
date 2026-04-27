package com.example.project5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.pizzaRecyclerView);

        List<PizzaOption> list = new ArrayList<>();

        list.add(new PizzaOption("Chicago Deluxe", R.drawable.deluxe));
        list.add(new PizzaOption("Chicago BBQ Chicken", R.drawable.bbq));
        list.add(new PizzaOption("Chicago Meatzza", R.drawable.meatzza));
        list.add(new PizzaOption("Chicago Build Your Own", R.drawable.byo));
        list.add(new PizzaOption("NY Deluxe", R.drawable.deluxe));
        list.add(new PizzaOption("NY BBQ Chicken", R.drawable.bbq));
        list.add(new PizzaOption("NY Meatzza", R.drawable.meatzza));
        list.add(new PizzaOption("NY Build Your Own", R.drawable.byo));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new PizzaAdapter(this, list));
    }
}