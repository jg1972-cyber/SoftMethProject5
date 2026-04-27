package com.example.project5;

import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Context;
import android.content.Intent;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {

    private List<PizzaOption> list;
    private Context context;

    public PizzaAdapter(Context context, List<PizzaOption> list) {
        this.context = context;
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.pizzaName);
            image = view.findViewById(R.id.pizzaImage);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.item_pizza, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PizzaOption p = list.get(position);
        holder.name.setText(p.name);
        holder.image.setImageResource(p.imageRes);

        // minimal click behavior (required for navigation)
        holder.itemView.setOnClickListener(v -> {
            if (p.name.contains("Chicago")) {
                context.startActivity(new Intent(context, ChicagoActivity.class));
            } else {
                context.startActivity(new Intent(context, NYActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
