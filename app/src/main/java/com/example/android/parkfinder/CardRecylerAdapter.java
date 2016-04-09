package com.example.android.parkfinder;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for creating ParkCard views in a Recycler View
 */
public class CardRecylerAdapter extends RecyclerView.Adapter<ParkCardHolder> {
    private List<Park> parks;

        public CardRecylerAdapter(List<Park> parks) {
        this.parks = parks;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ParkCardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.park_card, parent, false);

        return new ParkCardHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ParkCardHolder holder, int position) {
        Park park = parks.get(position);
        holder.setPark(park);
    }

    // Return the number of parks
    @Override
    public int getItemCount() {
        return parks.size();
    }
}

