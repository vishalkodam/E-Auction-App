package com.itw.auctionapp;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.itw.auctionapp.adapters.BidingAdapter;
import com.itw.auctionapp.databinding.ListingActivityBinding;
import com.itw.auctionapp.model.ItemListing;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ListingActivity extends AppCompatActivity {
    ListingActivityBinding activityBinding;
    List<ItemListing> itemBidBindings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = ListingActivityBinding.inflate(getLayoutInflater());
        setContentView(activityBinding.getRoot());
        setSupportActionBar(activityBinding.toolbar);
        getSupportActionBar().setTitle("Samsung S6");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getScreenWidthDp(this) >= 600) {
            CollapsingToolbarLayout collapsing_toolbar_layout = findViewById(R.id.collapsing_toolbar_layout);
            collapsing_toolbar_layout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.TRANSPARENT));
        }


        itemBidBindings.add(new ItemListing("Ramesh", "5000 (INR)"));
        itemBidBindings.add(new ItemListing("Suresh", "6100 (INR)"));
        itemBidBindings.add(new ItemListing("Popu", "6200 (INR)"));
        itemBidBindings.add(new ItemListing("Gogi", "6050 (INR)"));
        itemBidBindings.add(new ItemListing("Anuj Lathi", "4000 (INR)"));
        itemBidBindings.add(new ItemListing("Gargi", "5500 (INR)"));

        BidingAdapter bidingAdapter = new BidingAdapter(itemBidBindings);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        activityBinding.scroll2.recylerViewBidding.setLayoutManager(linearLayoutManager);
        activityBinding.scroll2.recylerViewBidding.setAdapter(bidingAdapter);

        Picasso.get()
                .load(R.drawable.s6)
                .into(activityBinding.imageScrollingTop);
    }

    public static int getScreenWidthDp(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }
}