package com.example.project5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PizzaOptionAdapter extends RecyclerView.Adapter<PizzaOptionAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(PizzaOption option);
    }

    private List<PizzaOption> options;
    private OnItemClickListener listener;

    public PizzaOptionAdapter(List<PizzaOption> options, OnItemClickListener listener) {
        this.options = options;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pizza_option_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PizzaOption option = options.get(position);

        holder.nameText.setText(option.getName());
        holder.imageView.setImageResource(option.getImageResource());

        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(option);
            }
        });
    }

    @Override
    public int getItemCount() {
        return options.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nameText;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.pizzaOptionName);
            imageView = itemView.findViewById(R.id.pizzaOptionImage);
        }
    }
}