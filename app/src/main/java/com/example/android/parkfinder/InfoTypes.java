package com.example.android.parkfinder;

/**
 * Represents the types of information that are relevant
 * for a park
 */
public enum InfoTypes {
    HOURS(R.drawable.ic_hours_18dp),
    FAMILY_FEATURES(R.drawable.ic_family_features_18dp),
    ACCESSIBILITY(R.drawable.ic_accessibility_18dp),
    AMENITIES(R.drawable.ic_amenities_18dp),
    EQUIPMENT(R.drawable.ic_equipment_18dp),
    WARNING(R.drawable.ic_warning_18dp);

    private int iconResource;

    InfoTypes(int imageResource) {
        this.iconResource = imageResource;
    }

    public int getIconResource() {
        return iconResource;
    }
}
