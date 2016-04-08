package com.example.android.parkfinder;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

/**
 * This returns Park objects.  In the future, it would
 * get these from a database of some sort.
 */
public class ParkRetriever {
    private final Context context;

    /**
     * Creates a ParkRetriever using the given Context to retrieve Resources from *
     *
     * @param context Context to retrieve resources from
     */
    public ParkRetriever(Context context) {
        this.context = context;
    }

    /**
     * Returns a Park object for South Rose Hill Park
     */
    public Park getSouthRoseHillPark() {
        Park park = new Park();

        String name = getResourceString(R.string.name_south_rose_hill_park);
        String description = getResourceString(R.string.description_south_rose_hill_park);
        park.setName(name);
        park.setDescription(description);

        String latitude = getResourceString(R.string.latitude_south_rose_hill_park);
        String longitude = getResourceString(R.string.longitude_south_rose_hill_park);
        float lat = Float.parseFloat(latitude);
        float lng = Float.parseFloat(longitude);
        park.setLocation(new LatLng(lat, lng));

        park.addImageResource(R.drawable.south_rose_hill_kirkland_1);

        String hours = getResourceString(R.string.hours_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String amenities = getResourceString(R.string.amenities_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.AMENITIES, amenities));

        String equipment = getResourceString(R.string.equip_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        return park;
    }

    /**
     * Returns a Park object for North Rose Hill Park
     */
    public Park getNorthRoseHillPark() {
        Park park = new Park();

        String name = getResourceString(R.string.name_north_rose_hill_park);
        String description = getResourceString(R.string.description_north_rose_hill_park);
        park.setName(name);
        park.setDescription(description);

        String latitude = getResourceString(R.string.latitude_north_rose_hill_park);
        String longitude = getResourceString(R.string.longitude_north_rose_hill_park);
        float lat = Float.parseFloat(latitude);
        float lng = Float.parseFloat(longitude);
        park.setLocation(new LatLng(lat, lng));

        // TODO: fix the images
        park.addImageResource(R.drawable.south_rose_hill_kirkland_1);

        String hours = getResourceString(R.string.hours_north_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String amenities = getResourceString(R.string.amenities_north_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.AMENITIES, amenities));

        String equipment = getResourceString(R.string.equip_north_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        return park;
    }

    // TODO: Finish adding the other parks

    /**
     * Returns the given resource string from Context
     */
    private String getResourceString(int id) {
        return context.getResources().getString(id);
    }
}
