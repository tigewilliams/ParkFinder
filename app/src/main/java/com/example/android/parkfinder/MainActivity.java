package com.example.android.parkfinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecylerView();
        populateParks();
    }

    private void setupRecylerView() {
        recyclerView = (RecyclerView) findViewById(R.id.mainRecycler);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerLayoutManager);
    }
    private void populateParks() {
        ParkRetriever parkRetriever = new ParkRetriever(this);
        List<Park> parks = parkRetriever.getAllParks();

        CardRecylerAdapter adapter = new CardRecylerAdapter(parks);
        recyclerView.setAdapter(adapter);
    }
}