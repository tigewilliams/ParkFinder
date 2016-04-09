package com.example.android.parkfinder;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * View Holder class for a Park's CardView
 */
public class ParkCardHolder extends RecyclerView.ViewHolder {
    private final float occupancyIconHolderHigh = 3.0f;
    private final float occupancyIconHolderMedium = 5.0f;
    private final float occupancyIconHolderLow = 5.0f;

    private final float occupancyBarHigh = 8.0f;
    private final float occupancyBarMedium = 4.0f;
    private final float occupancyBarLow = 1.0f;

    private Park park;
    private ImageView parkImage;
    private TextView parkName;
    private LinearLayout parkFeatures;
    private RatingBar parkRating;
    private RelativeLayout parkOccupancyIconHolder;
    private View parkOccupancyBar;

    public ParkCardHolder(View view) {
        super(view);

        setOnClickHandler(view);
        setChildViews(view);
    }

    /**
     * Gets the Park associated with the ParkCardHolder
     */
    public Park getPark() {
        return park;
    }

    /**
     * Sets the Park for the ParkCardHolder
     */
    public void setPark(Park newPark) {
        park = newPark;

        updateParkViews();
    }

    private void setOnClickHandler(View view) {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If there is a park set on this holder, then
                // start the "View Park" activity using the park
                if (park != null) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, ViewParkActivity.class);
                    intent.putExtra(IntentExtras.EXTRA_PARK, park);
                    context.startActivity(intent);
                }
            }
        };

        view.setOnClickListener(listener);
    }

    private void setChildViews(View view) {
        parkImage = (ImageView) view.findViewById(R.id.parkCardImage);
        parkName = (TextView) view.findViewById(R.id.parkCardName);
        parkFeatures = (LinearLayout) view.findViewById(R.id.parkCardFeatures);
        parkRating = (RatingBar) view.findViewById(R.id.parkCardRating);
        parkOccupancyIconHolder = (RelativeLayout) view.findViewById(R.id.parkCardOccupancyIconHolder);
        parkOccupancyBar = view.findViewById(R.id.parkCardOccupancyBar);
    }

    private void updateParkViews() {
        // TODO: define a "primary" image instead of just taking the first one.
        parkImage.setImageResource(park.getImageResources().get(0));
        parkName.setText(park.getName());
        parkRating.setRating(park.getRating());
        setParkInfoItems(park.getInfoItems());
        setParkPopulation(park.getPopulationLevel());
    }

    private void setParkInfoItems(List<InfoItem> infoItems) {
        clearParkInfoItems();

        int itemCount = infoItems.size();
        for (int i = 0; i < itemCount; i++) {
            InfoItem item = infoItems.get(i);
            setParkInfoItem(item);
        }
    }

    private void clearParkInfoItems() {
        if (parkFeatures.getChildCount() > 0)
            parkFeatures.removeAllViews();
    }

    private void setParkInfoItem(InfoItem item) {
        ImageView itemView = createInfoItemImageView(item);
        parkFeatures.addView(itemView);
    }

    private ImageView createInfoItemImageView(InfoItem item) {
        Context context = itemView.getContext();
        ImageView imageView = new ImageView(context);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        imageView.setLayoutParams(params);
        imageView.setImageResource(item.getInfoType().getIconResource());

        return imageView;
    }

    private void setParkPopulation(PopulationLevels population) {
        switch (population) {
            case HIGH:
                setOccupancyIconHolderHigh();
                setOccupancyBarHigh();
                return;

            case MEDIUM:
                setOccupancyIconHolderMedium();
                setOccupancyBarMedium();
                return;

            case LOW:
                setOccupancyIconHolderLow();
                setOccupancyBarLow();
                return;

            default:
                // We shouldn't get to this case, but just turn them all
                // off just in case we do.  Defaulting it to "High" mode.
                setOccupancyIconHolderHigh();
                setOccupancyBarHigh();
        }
    }

    private void setOccupancyIconHolderHigh() {
        LinearLayout.LayoutParams params = getOccupancyIconHolderHighParams();
        parkOccupancyIconHolder.setLayoutParams(params);
    }

    private void setOccupancyIconHolderMedium() {
        LinearLayout.LayoutParams params = getOccupancyIconHolderMediumParams();
        parkOccupancyIconHolder.setLayoutParams(params);
    }

    private void setOccupancyIconHolderLow() {
        LinearLayout.LayoutParams params = getOccupancyIconHolderLowParams();
        parkOccupancyIconHolder.setLayoutParams(params);
    }

    private void setOccupancyBarHigh() {
        LinearLayout.LayoutParams params = getOccupancyBarHighParams();
        parkOccupancyBar.setLayoutParams(params);

        int backGroundColor = ContextCompat.getColor(parkOccupancyBar.getContext(),
                R.color.colorIndicatorHigh);

        parkOccupancyBar.setBackgroundColor(backGroundColor);
    }

    private void setOccupancyBarMedium() {
        LinearLayout.LayoutParams params = getOccupancyBarMediumParams();
        parkOccupancyBar.setLayoutParams(params);

        int backGroundColor = ContextCompat.getColor(parkOccupancyBar.getContext(),
                R.color.colorIndicatorMedium);

        parkOccupancyBar.setBackgroundColor(backGroundColor);
    }

    private void setOccupancyBarLow() {
        LinearLayout.LayoutParams params = getOccupancyBarLowParams();
        parkOccupancyBar.setLayoutParams(params);

        int backGroundColor = ContextCompat.getColor(parkOccupancyBar.getContext(),
                R.color.colorIndicatorLow);

        parkOccupancyBar.setBackgroundColor(backGroundColor);
    }

    private LinearLayout.LayoutParams getOccupancyIconHolderHighParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // width
                0, // height
                occupancyIconHolderHigh); // weight
        return params;
    }

    private LinearLayout.LayoutParams getOccupancyIconHolderMediumParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // width
                0, // height
                occupancyIconHolderMedium); // weight
        return params;
    }

    private LinearLayout.LayoutParams getOccupancyIconHolderLowParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, // width
                0, // height
                occupancyIconHolderLow); // weight
        return params;
    }

    private LinearLayout.LayoutParams getOccupancyBarHighParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                getOccupancyBarWidth(), // width
                0, // height
                occupancyBarHigh); // weight
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private LinearLayout.LayoutParams getOccupancyBarMediumParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                getOccupancyBarWidth(), // width
                0, // height
                occupancyBarMedium); // weight
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    private LinearLayout.LayoutParams getOccupancyBarLowParams() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                getOccupancyBarWidth(), // width
                0, // height
                occupancyBarLow); // weight
        params.gravity = Gravity.CENTER_HORIZONTAL;
        return params;
    }

    int getOccupancyBarWidth() {
        return (int) parkOccupancyBar.getResources()
                .getDimension(R.dimen.occupancy_bar_width);
    }

    private Drawable getResourceImage(int id) {
        Context context = itemView.getContext();
        return ContextCompat.getDrawable(context, id);
    }
}
