package com.example.week_11.ui;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.week_11.R;
import com.example.week_11.adapter.SoccerAdapter;
import com.example.week_11.model.SoccerEntity;
import java.util.List;

public class SoccerListFragment<T extends SoccerEntity> extends Fragment {

    private List<T> data;
    private SoccerAdapter<T> adapter;

    // constructor to define data
    public SoccerListFragment(List<T> data) {
        this.data = data;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // inflate the XML layout file and convert it into a View object
        View view = inflater.inflate(R.layout.fragment_soccer_list, container, false);

        // find the RecyclerView component within the inflated layout by its ID
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // set a LayoutManager to define how items are positioned
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // initialize generic adapter with the data passed
        adapter = new SoccerAdapter<>(data);

        // connect adapter to the RecyclerView to start rendering list items
        recyclerView.setAdapter(adapter);

        // return configured view to be displayed on the screen
        return view;
    }

    // update list for search result
    public void updateList(List<T> newList) {
        if (adapter != null) {
            adapter.updateData(newList);
        }
    }
}