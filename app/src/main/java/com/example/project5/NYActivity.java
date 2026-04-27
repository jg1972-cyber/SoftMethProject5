package com.example.project5;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.project5.backend.*;

public class NYActivity extends AppCompatActivity {

    private Spinner pizzaTypeSpinner, sizeSpinner, availableToppingsSpinner;
    private TextView crustText, priceText;
    private ListView selectedToppingsList;
    private Button createButton, addToppingButton, removeToppingButton, addToOrderButton, backButton;
    private ImageView pizzaImageView;
    private Pizza currentPizza;
    private ArrayAdapter<Topping> selectedToppingsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ny);

        pizzaImageView = findViewById(R.id.pizzaImageView);
        pizzaTypeSpinner = findViewById(R.id.pizzaTypeSpinner);
        sizeSpinner = findViewById(R.id.sizeSpinner);
        availableToppingsSpinner = findViewById(R.id.availableToppingsSpinner);
        selectedToppingsList = findViewById(R.id.selectedToppingsList);
        crustText = findViewById(R.id.crustText);
        priceText = findViewById(R.id.priceText);

        createButton = findViewById(R.id.createButton);
        addToppingButton = findViewById(R.id.addToppingButton);
        removeToppingButton = findViewById(R.id.removeToppingButton);
        addToOrderButton = findViewById(R.id.addToOrderButton);
        backButton = findViewById(R.id.backButton);

        setupSpinners();

        createButton.setOnClickListener(v -> createPizza());
        addToppingButton.setOnClickListener(v -> addTopping());
        removeToppingButton.setOnClickListener(v -> removeTopping());
        addToOrderButton.setOnClickListener(v -> addToOrder());
        backButton.setOnClickListener(v -> finish());

        String selectedPizza = getIntent().getStringExtra("pizzaType");

        if (selectedPizza != null) {
            selectedPizza = selectedPizza
                    .replace("Chicago ", "")
                    .replace("NY ", "");

            ArrayAdapter adapter = (ArrayAdapter) pizzaTypeSpinner.getAdapter();
            int position = adapter.getPosition(selectedPizza);

            if (position >= 0) {
                pizzaTypeSpinner.setSelection(position);
                createPizza();
            }
        } else {
            refreshView();
        }
    }
    private int getPizzaImageResource() {
        String type = pizzaTypeSpinner.getSelectedItem().toString();

        switch (type) {
            case "Deluxe":
                return R.drawable.deluxe;
            case "BBQ Chicken":
                return R.drawable.bbq;
            case "Meatzza":
                return R.drawable.meatzza;
            case "Build Your Own":
                return R.drawable.byo;
            default:
                return R.drawable.byo;
        }
    }
    private void setupSpinners() {
        String[] pizzaTypes = {"Deluxe", "BBQ Chicken", "Meatzza", "Build Your Own"};

        pizzaTypeSpinner.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, pizzaTypes));

        sizeSpinner.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, Size.values()));

        availableToppingsSpinner.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, Topping.values()));

        selectedToppingsAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1);

        selectedToppingsList.setAdapter(selectedToppingsAdapter);
    }

    private void createPizza() {
        String type = pizzaTypeSpinner.getSelectedItem().toString();
        Size size = (Size) sizeSpinner.getSelectedItem();

        PizzaFactory factory = new NYPizza();

        switch (type) {
            case "Deluxe":
                currentPizza = factory.createDeluxe();
                break;
            case "BBQ Chicken":
                currentPizza = factory.createBBQChicken();
                break;
            case "Meatzza":
                currentPizza = factory.createMeatzza();
                break;
            case "Build Your Own":
                currentPizza = factory.createBuildYourOwn();
                break;
        }

        currentPizza.setSize(size);
        refreshView();
    }

    private void addTopping() {
        if (!(currentPizza instanceof BuildYourOwn)) {
            return;
        }

        Topping topping = (Topping) availableToppingsSpinner.getSelectedItem();

        if (currentPizza.getToppings().contains(topping)) {
            return;
        }

        if (currentPizza.getToppings().size() >= 5) {
            showMessage("Topping Limit", "Build Your Own pizzas can have at most 5 toppings.");
            return;
        }

        currentPizza.addTopping(topping);
        refreshView();
    }

    private void removeTopping() {
        if (!(currentPizza instanceof BuildYourOwn)) {
            return;
        }

        int position = selectedToppingsList.getCheckedItemPosition();

        if (position == ListView.INVALID_POSITION) {
            return;
        }

        Topping topping = selectedToppingsAdapter.getItem(position);
        currentPizza.removeTopping(topping);
        selectedToppingsList.clearChoices();
        refreshView();
    }

    private void addToOrder() {
        if (currentPizza == null) {
            return;
        }

        AppSingleton.getInstance().getCurrentOrder().addPizza(currentPizza);
        showMessage("Pizza Added", "Pizza added to current order.");

        currentPizza = null;
        refreshView();
    }

    private void refreshView() {
        selectedToppingsAdapter.clear();

        if (currentPizza == null) {
            crustText.setText("");
            priceText.setText("$0.00");
            pizzaImageView.setImageResource(0);
            selectedToppingsAdapter.notifyDataSetChanged();
            return;
        }

        pizzaImageView.setImageResource(getPizzaImageResource());
        selectedToppingsAdapter.addAll(currentPizza.getToppings());
        crustText.setText(String.valueOf(currentPizza.getCrust()));
        priceText.setText("$" + String.format("%.2f", currentPizza.price()));
        selectedToppingsAdapter.notifyDataSetChanged();
    }

    private void showMessage(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}