package com.example.android.parkfinder;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

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

    /** Returns all of the Parks */
    public List<Park> getAllParks() {
        ArrayList<Park> parks = new ArrayList<Park>();
        parks.add(getSouthRoseHillPark());
        parks.add(getNorthRoseHillPark());
        parks.add(getGrassLawnPark());
        parks.add(getPeterKirkPark());
        parks.add(getTerracePark());
        return parks;
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

        park.addImageResource(R.drawable.south_rose_hill_1);
        park.addImageResource(R.drawable.south_rose_hill_2);
        park.addImageResource(R.drawable.south_rose_hill_3);

        String hours = getResourceString(R.string.hours_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String amenities = getResourceString(R.string.amenities_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.AMENITIES, amenities));

        String equipment = getResourceString(R.string.equip_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        String warning = getResourceString(R.string.warning_south_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.WARNING, warning));

        String rating = getResourceString(R.string.rating_south_rose_hill_park);
        park.setRating(Float.parseFloat(rating));

        String population = getResourceString(R.string.population_south_rose_hill_park);
        park.setPopulationLevel(PopulationLevels.valueOf(population));

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

        park.addImageResource(R.drawable.north_rose_hill_woodlands_1);
        park.addImageResource(R.drawable.north_rose_hill_woodlands_2);
        park.addImageResource(R.drawable.north_rose_hill_woodlands_3);
        park.addImageResource(R.drawable.north_rose_hill_woodlands_4);

        String hours = getResourceString(R.string.hours_north_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String equipment = getResourceString(R.string.equip_north_rose_hill_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        String rating = getResourceString(R.string.rating_north_rose_hill_park);
        park.setRating(Float.parseFloat(rating));

        String population = getResourceString(R.string.population_north_rose_hill_park);
        park.setPopulationLevel(PopulationLevels.valueOf(population));

        return park;
    }

    /** Returns a Park object for Peter Kirk Park */
    public Park getPeterKirkPark() {
        Park park = new Park();

        String name = getResourceString(R.string.name_peter_kirk_park);
        String description = getResourceString(R.string.description_peter_kirk_park);
        park.setName(name);
        park.setDescription(description);

        String latitude = getResourceString(R.string.latitude_peter_kirk_park);
        String longitude = getResourceString(R.string.longitude_peter_kirk_park);
        float lat = Float.parseFloat(latitude);
        float lng = Float.parseFloat(longitude);
        park.setLocation(new LatLng(lat, lng));

        park.addImageResource(R.drawable.peter_kirk_1);
        park.addImageResource(R.drawable.peter_kirk_2);
        park.addImageResource(R.drawable.peter_kirk_3);

        String hours = getResourceString(R.string.hours_peter_kirk_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String amenities = getResourceString(R.string.amenities_peter_kirk_park);
        park.addInfoItem(new InfoItem(InfoTypes.AMENITIES, amenities));

        String equipment = getResourceString(R.string.equip_peter_kirk_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        String warning = getResourceString(R.string.warning_peter_kirk_park);
        park.addInfoItem(new InfoItem(InfoTypes.WARNING, warning));

        String rating = getResourceString(R.string.rating_peter_kirk_park);
        park.setRating(Float.parseFloat(rating));

        String population = getResourceString(R.string.population_peter_kirk_park);
        park.setPopulationLevel(PopulationLevels.valueOf(population));

        return park;
    }

    /** Returns a Park object for Terrace Park */
    public Park getTerracePark() {
        Park park = new Park();

        String name = getResourceString(R.string.name_terrace_park);
        String description = getResourceString(R.string.description_terrace_park);
        park.setName(name);
        park.setDescription(description);

        String latitude = getResourceString(R.string.latitude_terrace_park);
        String longitude = getResourceString(R.string.longitude_terrace_park);
        float lat = Float.parseFloat(latitude);
        float lng = Float.parseFloat(longitude);
        park.setLocation(new LatLng(lat, lng));

        park.addImageResource(R.drawable.terrace_1);
        park.addImageResource(R.drawable.terrace_2);
        park.addImageResource(R.drawable.terrace_3);
        park.addImageResource(R.drawable.terrace_4);

        String hours = getResourceString(R.string.hours_terrace_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String equipment = getResourceString(R.string.equip_terrace_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        String rating = getResourceString(R.string.rating_terrace_park);
        park.setRating(Float.parseFloat(rating));

        String population = getResourceString(R.string.population_terrace_park);
        park.setPopulationLevel(PopulationLevels.valueOf(population));

        return park;
    }

    /** Returns a Park object for Grass Lawn Park */
    public Park getGrassLawnPark() {
        Park park = new Park();

        String name = getResourceString(R.string.name_grass_lawn_park);
        String description = getResourceString(R.string.description_grass_lawn_park);
        park.setName(name);
        park.setDescription(description);

        String latitude = getResourceString(R.string.latitude_grass_lawn_park);
        String longitude = getResourceString(R.string.longitude_grass_lawn_park);
        float lat = Float.parseFloat(latitude);
        float lng = Float.parseFloat(longitude);
        park.setLocation(new LatLng(lat, lng));

        park.addImageResource(R.drawable.grass_lawn_1);
        park.addImageResource(R.drawable.grass_lawn_2);
        park.addImageResource(R.drawable.grass_lawn_3);
        park.addImageResource(R.drawable.grass_lawn_4);

        String hours = getResourceString(R.string.hours_grass_lawn_park);
        park.addInfoItem(new InfoItem(InfoTypes.HOURS, hours));

        String amenities = getResourceString(R.string.amenities_grass_lawn_park);
        park.addInfoItem(new InfoItem(InfoTypes.AMENITIES, amenities));

        String equipment = getResourceString(R.string.equip_grass_lawn_park);
        park.addInfoItem(new InfoItem(InfoTypes.EQUIPMENT, equipment));

        String warning = getResourceString(R.string.warning_grass_lawn_park);
        park.addInfoItem(new InfoItem(InfoTypes.WARNING, warning));

        String rating = getResourceString(R.string.rating_grass_lawn_park);
        park.setRating(Float.parseFloat(rating));

        String population = getResourceString(R.string.population_grass_lawn_park);
        park.setPopulationLevel(PopulationLevels.valueOf(population));

        return park;
    }

    /**
     * Returns the given resource string from Context
     */
    private String getResourceString(int id) {
        return context.getResources().getString(id);
    }
}
