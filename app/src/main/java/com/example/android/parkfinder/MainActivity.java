package com.example.android.parkfinder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Park park;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParkRetriever parkRetriever = new ParkRetriever(this);
        park = parkRetriever.getSouthRoseHillPark();
    }

    public void viewPark(View view) {
        Intent intent = new Intent(this, ViewParkActivity.class);
        intent.putExtra(IntentExtras.EXTRA_PARK, park);
        startActivity(intent);
    }
}
