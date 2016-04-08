package com.example.android.parkfinder;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Contains information about an individual park
 */
public class Park implements Parcelable {
    /**
     * Creator for the Parcelable interface
     */
    public static final Parcelable.Creator<Park> CREATOR = new Parcelable.Creator<Park>() {

        @Override
        public Park createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            return new Park(source);  //using parcelable constructor
        }

        @Override
        public Park[] newArray(int size) {
            // TODO Auto-generated method stub
            return new Park[size];
        }
    };

    private String name;
    private String description;
    private LatLng location;
    private ArrayList<Integer> imageResources = new ArrayList<Integer>();
    private ArrayList<InfoItem> infoItems = new ArrayList<InfoItem>();

    /**
     * Creates a new empty Park
     */
    public Park() {
    }

    /**
     * Creates a new Park from a Parcel.  Used to send Parks via Intents.
     * Park parcels are written in the following order:
     * 1) name
     * 2) description
     * 3) location.latitude
     * 4) location.longitude
     * 5) number of images (int)
     * 6) image resource IDs
     * 7) number of info items
     * 8) for each info item:
     * i) infoType (int)
     * ii) description
     */
    public Park(Parcel in) {

        this.name = in.readString();
        this.description = in.readString();

        double lat = in.readDouble();
        double lng = in.readDouble();
        this.location = new LatLng(lat, lng);

        int imageCount = in.readInt();
        for (int i = 0; i < imageCount; i++) {
            int imageId = in.readInt();
            this.addImageResource(imageId);
        }

        int infoCount = in.readInt();
        for (int i = 0; i < infoCount; i++) {
            InfoTypes infoType = InfoTypes.values()[in.readInt()];
            String description = in.readString();
            InfoItem infoItem = new InfoItem(infoType, description);
            this.addInfoItem(infoItem);
        }
    }

    /**
     * Returns the name of the park
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the park
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Returns the description of the park
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for the park
     */
    public void setDescription(String newDescription) {
        description = newDescription;
    }

    /**
     * Returns the geographical location of the park
     */
    public LatLng getLocation() {
        return location;
    }

    /**
     * Sets the geographical location of the park
     */
    public void setLocation(LatLng newLocation) {
        location = newLocation;
    }

    /**
     * Returns the resource IDs for images of the park
     */
    public List<Integer> getImageResources() {
        return Collections.unmodifiableList(imageResources);
    }

    /**
     * Adds a new image resource for the park
     */
    public void addImageResource(int newImageResource) {
        // only add the image resource if it hasn't already be added.
        if (!imageResources.contains(newImageResource)) {
            imageResources.add(newImageResource);
        }
    }

    /**
     * Returns an array of resource IDs for images of the park
     */
    public List<InfoItem> getInfoItems() {
        return Collections.unmodifiableList(infoItems);
    }

    /**
     * Adds a new info item for the park
     */
    public void addInfoItem(InfoItem newInfoItem) {
        // only add the image resource if it hasn't already be added.
        if (!infoItems.contains(newInfoItem)) {
            infoItems.add(newInfoItem);
        }
    }

    // Parcelable implementation
    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * Writes a Park to a Parcel in the following order:
     * 1) name
     * 2) description
     * 3) location.latitude
     * 4) location.longitude
     * 5) number of images (int)
     * 6) image resource IDs
     * 7) number of info items
     * 8) for each info item:
     * i) infoType (int)
     * ii) description
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);

        // write the location
        dest.writeDouble(this.location.latitude);
        dest.writeDouble(this.location.longitude);

        // Write the image IDs
        dest.writeInt(this.imageResources.size());
        for (int i = 0; i < this.imageResources.size(); i++) {
            dest.writeInt(this.imageResources.get(i));
        }

        // Write the info items
        dest.writeInt(this.infoItems.size());
        for (int i = 0; i < this.infoItems.size(); i++) {
            InfoItem infoItem = this.infoItems.get(i);

            dest.writeInt(infoItem.getInfoType().ordinal());
            dest.writeString(infoItem.getDescription());
        }
    }
}
