package com.example.android.parkfinder;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * View Holder class for a Park's CardView
 */
public class ParkCardHolder extends RecyclerView.ViewHolder {
    private Park park;
    private ImageView parkImage;
    private TextView parkName;
    private LinearLayout parkFeatures;
    private RatingBar parkRating;
    private ImageView parkPopulationLow;
    private ImageView parkPopulationMedium;
    private ImageView parkPopulationHigh;

    public ParkCardHolder(View view){
        super(view);

        setOnClickHandler(view);
        setChildViews(view);
    }

    /** Sets the Park for the ParkCardHolder */
    public void setPark(Park newPark) {
        park = newPark;

        updateParkViews();
    }

    /** Gets the Park associated with the ParkCardHolder */
    public Park getPark() {
        return park;
    }

    private void setOnClickHandler(View view){
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

    private void setChildViews(View view){
        parkImage = (ImageView) view.findViewById(R.id.parkCardImage);
        parkName = (TextView) view.findViewById(R.id.parkCardName);
        parkFeatures = (LinearLayout) view.findViewById(R.id.parkCardFeatures);
        parkRating = (RatingBar) view.findViewById(R.id.parkCardRating);
        parkPopulationLow = (ImageView) view.findViewById(R.id.parkCardPopLow);
        parkPopulationMedium = (ImageView) view.findViewById(R.id.parkCardPopMedium);
        parkPopulationHigh = (ImageView) view.findViewById(R.id.parkCardPopHigh);
    }

    private void updateParkViews(){
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
        Drawable indicatorOn = getResourceImage(R.drawable.ic_indicator_filled_18dp);
        Drawable indicatorOff = getResourceImage(R.drawable.ic_indicator_empty_18dp);

        switch (population) {
            case HIGH:
                parkPopulationHigh.setImageDrawable(indicatorOn);
                parkPopulationMedium.setImageDrawable(indicatorOn);
                parkPopulationLow.setImageDrawable(indicatorOn);
                return;

            case MEDIUM:
                parkPopulationHigh.setImageDrawable(indicatorOff);
                parkPopulationMedium.setImageDrawable(indicatorOn);
                parkPopulationLow.setImageDrawable(indicatorOn);
                return;

            case LOW:
                parkPopulationHigh.setImageDrawable(indicatorOff);
                parkPopulationMedium.setImageDrawable(indicatorOff);
                parkPopulationLow.setImageDrawable(indicatorOn);
                return;

            default:
                // We shouldn't get to this case, but just turn them all
                // off just in case we do.
                parkPopulationHigh.setImageDrawable(indicatorOff);
                parkPopulationMedium.setImageDrawable(indicatorOff);
                parkPopulationLow.setImageDrawable(indicatorOff);
        }
    }

    private Drawable getResourceImage(int id) {
        Context context = itemView.getContext();
        return ContextCompat.getDrawable(context, id);
    }
}
