package com.example.android.parkfinder;

/**
 * Represents an informational item about the park,
 * such as its hours of operation or whether or
 * not it has public restrooms.
 */
public class InfoItem {
    private final InfoTypes infoType;
    private final String description;

    /**
     * Creates a new InfoItem with the given
     * description and icon resource ID
     *
     * @param infoType    The type of info for this item
     * @param description The description
     */
    public InfoItem(InfoTypes infoType, String description) {
        this.infoType = infoType;
        this.description = description;
    }

    /**
     * Returns the type of info this represents.
     */
    public InfoTypes getInfoType() {
        return infoType;
    }

    /**
     * Returns the description.
     */
    public String getDescription() {
        return description;
    }
}
