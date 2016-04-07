package com.example.android.parkfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        LatLng loc = new LatLng(47.6688893, -122.169511);

        map.addMarker(new MarkerOptions()
                .position(loc)
                .title("South Rose Hill Park"));

        float zoom = 12.0f;
        float tilt = 0.0f;
        float bearing = 0.0f;
        CameraPosition pos = new CameraPosition(loc, zoom, tilt, bearing);
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(pos);
        map.moveCamera(update);
    }
}
