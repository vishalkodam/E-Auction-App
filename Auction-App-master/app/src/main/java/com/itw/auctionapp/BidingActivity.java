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
import com.itw.auctionapp.databinding.ActivityBidingBinding;
import com.itw.auctionapp.model.ItemListing;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class BidingActivity extends AppCompatActivity {

    ActivityBidingBinding acivityBinding;
    List<ItemListing> itemBidBindings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acivityBinding = ActivityBidingBinding.inflate(getLayoutInflater());
        setContentView(acivityBinding.getRoot());
        setSupportActionBar(acivityBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Iphone 11");
        if (getScreenWidthDp(this) >= 600) {
            CollapsingToolbarLayout collapsing_toolbar_layout = findViewById(R.id.collapsing_toolbar_layout);
            collapsing_toolbar_layout.setExpandedTitleTextColor(ColorStateList.valueOf(Color.TRANSPARENT));
        }

        itemBidBindings.add(new ItemListing("Sam", "50000 (INR)"));
        itemBidBindings.add(new ItemListing("Andrea", "61000 (INR)"));
        itemBidBindings.add(new ItemListing("Alex", "62000 (INR)"));
        itemBidBindings.add(new ItemListing("Jack", "60500 (INR)"));
        itemBidBindings.add(new ItemListing("Robert", "40000 (INR)"));
        itemBidBindings.add(new ItemListing("Silly", "55000 (INR)"));

        BidingAdapter bidingAdapter = new BidingAdapter(itemBidBindings);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        acivityBinding.scroll.recylerViewBidding.setLayoutManager(linearLayoutManager);
        acivityBinding.scroll.recylerViewBidding.setAdapter(bidingAdapter);

        Picasso.get()
                .load(R.drawable.iphone)
                .into(acivityBinding.imageScrollingTop);
    }

    public static int getScreenWidthDp(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (displayMetrics.widthPixels / displayMetrics.density);
    }
}