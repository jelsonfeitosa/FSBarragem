package com.leenadam.app.Empresa;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;
import com.leenadam.app.R;
import com.leenadam.app.util.FirestoreAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * RecyclerView adapter for a list of Restaurants.
 */
public class AdapterEmpresa extends FirestoreAdapter<AdapterEmpresa.ViewHolder> {

    public interface OnRestaurantSelectedListener {

        void onRestaurantSelected(DocumentSnapshot restaurant);

    }

    private OnRestaurantSelectedListener mListener;

    public AdapterEmpresa(Query query, OnRestaurantSelectedListener listener) {
        super(query);
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(R.layout.item_empresa, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(getSnapshot(position), mListener);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(final DocumentSnapshot snapshot,
                         final OnRestaurantSelectedListener listener) {

        }

        /*
        @BindView(R.id.restaurantItemImage)
        ImageView imageView;
        @BindView(R.id.restaurantItemName)
        TextView nameView;
        @BindView(R.id.restaurantItemRating)
        MaterialRatingBar ratingBar;
        @BindView(R.id.restaurantItemNumRatings)
        TextView numRatingsView;
        @BindView(R.id.restaurantItemPrice)
        TextView priceView;
        @BindView(R.id.restaurantItemCategory)
        TextView categoryView;
        @BindView(R.id.restaurantItemCity)
        TextView cityView;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        public void bind(final DocumentSnapshot snapshot,
                         final OnRestaurantSelectedListener listener) {
            Restaurant restaurant = snapshot.toObject(Restaurant.class);
            Resources resources = itemView.getResources();
            // Load image
            Glide.with(imageView.getContext())
                    .load(restaurant.getPhoto())
                    .into(imageView);
            nameView.setText(restaurant.getName());
            ratingBar.setRating((float) restaurant.getAvgRating());
            cityView.setText(restaurant.getCity());
            categoryView.setText(restaurant.getCategory());
            numRatingsView.setText(resources.getString(R.string.fmt_num_ratings,
                    restaurant.getNumRatings()));
            priceView.setText(RestaurantUtil.getPriceString(restaurant));
            // Click listener
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        listener.onRestaurantSelected(snapshot);
                    }
                }
            });
        }
        */

    }
}