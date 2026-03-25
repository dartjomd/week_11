package com.example.week_11.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.week_11.R;
import com.example.week_11.model.SoccerEntity;
import java.util.List;

// generic adapter that works with any class implementing SoccerEntity interface
public class SoccerAdapter<T extends SoccerEntity> extends RecyclerView.Adapter<SoccerAdapter.ViewHolder> {

    private List<T> items;

    public SoccerAdapter(List<T> items) {
        this.items = items;
    }

    // updates current list with filtered data and refreshes UI
    public void updateData(List<T> newItems) {
        this.items = newItems;
        notifyDataSetChanged(); // notifies RecyclerView to redraw the items
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infate the custom layout for a single row
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_soccer_entity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // get data object for current position
        T item = items.get(position);

        // bind the data to UI components
        holder.nameTextView.setText(item.getName());
        holder.subInfoTextView.setText("ID: " + item.getId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    // ViewHolder class holds references to the views for each data item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView subInfoTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.entityName);
            subInfoTextView = itemView.findViewById(R.id.entitySubInfo);
        }
    }
}