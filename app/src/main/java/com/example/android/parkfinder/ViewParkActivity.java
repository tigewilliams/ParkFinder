package com.example.android.parkfinder;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ViewParkActivity extends AppCompatActivity
        implements OnMapReadyCallback {

    private Park park;

    /**
     * Sends an Intent to Navigate to the Park
     */
    public void navigateToPark(View view) {
        LatLng loc = park.getLocation();
        Uri gmmIntentUri = Uri.parse("google.navigation:q=" + loc.latitude + "," + loc.longitude);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_park);

        Intent intent = getIntent();
        park = getParkFromIntent(intent);

        setParkViews(park);
        setupGoogleMaps();
    }

    private Park getParkFromIntent(Intent intent) {
        return intent.getParcelableExtra(IntentExtras.EXTRA_PARK);
    }

    /**
     * Sets all of the various UI views to use the Park
     */
    private void setParkViews(Park park) {
        setActivityLabel(park);
        setParkImage(park);
        setParkInfoItems(park);
        setParkDescription(park);
    }

    private void setActivityLabel(Park park) {
        this.setTitle(park.getName());
    }

    private void setParkImage(Park park) {
        // TODO: make this an image carousel
        ImageView parkImageView = (ImageView) this.findViewById(R.id.parkImage);
        parkImageView.setImageResource(park.getImageResources().get(0));
    }

    private void setParkInfoItems(Park park) {

    }

    private void setParkDescription(Park park) {
        TextView parkDescriptionView = (TextView) this.findViewById(R.id.parkDescription);
        parkDescriptionView.setText(park.getDescription());
    }

    /**
     * Google Maps API Setup
     */
    private void setupGoogleMaps() {
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        addParkMapMarker(park, map);
        zoomMapToPark(park, map);
    }

    private void addParkMapMarker(Park park, GoogleMap map) {
        // add a marker on the location of the park
        map.addMarker(new MarkerOptions()
                .position(park.getLocation())
                .title(park.getName()));
    }

    private void zoomMapToPark(Park park, GoogleMap map) {
        LatLng loc = park.getLocation();

        String zoomString = getResources().getString(R.string.default_google_maps_zoom);
        String tiltString = getResources().getString(R.string.default_google_maps_tilt);
        String bearingString = getResources().getString(R.string.default_google_maps_bearing);

        float zoom = Float.parseFloat(zoomString);
        float tilt = Float.parseFloat(tiltString);
        float bearing = Float.parseFloat(bearingString);

        CameraPosition pos = new CameraPosition(loc, zoom, tilt, bearing);
        CameraUpdate update = CameraUpdateFactory.newCameraPosition(pos);
        map.moveCamera(update);
    }
}
