package com.itw.auctionapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.itw.auctionapp.adapters.BidingListAdapter;
import com.itw.auctionapp.databinding.FragmentBiddingBinding;
import com.itw.auctionapp.model.ItemListing;

import java.util.ArrayList;
import java.util.List;

public class BiddingFragment extends Fragment {

    FragmentBiddingBinding biddingBinding;
    List<ItemListing> itemListings = new ArrayList<>();


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        biddingBinding = FragmentBiddingBinding.inflate(inflater, container, false);

        setListItems();

        BidingListAdapter bidingListAdapter = new BidingListAdapter(itemListings);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        biddingBinding.listSearch.setLayoutManager(linearLayoutManager);
        biddingBinding.listSearch.setAdapter(bidingListAdapter);

        return biddingBinding.getRoot();

    }

    private void setListItems() {
        itemListings.add(new ItemListing("Iphone 10 pro", "55,000 (INR)", "India", getResources().getDrawable(R.drawable.iphone)));
        itemListings.add(new ItemListing("Iphone 10 ", "60,000 (INR)", "China", getResources().getDrawable(R.drawable.image1)));
        itemListings.add(new ItemListing("Iphone 10 pro", "58,000 (INR)", "India", getResources().getDrawable(R.drawable.i2)));
        itemListings.add(new ItemListing("Iphone 11 pro", "75,000 (INR)", "India", getResources().getDrawable(R.drawable.i3)));
        itemListings.add(new ItemListing("Iphone X", "49,000 (INR)", "Thailand", getResources().getDrawable(R.drawable.i4)));
        itemListings.add(new ItemListing("Iphone X 2017", "45,000 (INR)", "Netherlands", getResources().getDrawable(R.drawable.i5)));
        itemListings.add(new ItemListing("Iphone 5", "35,000 (INR)", "India", getResources().getDrawable(R.drawable.i6)));
        itemListings.add(new ItemListing("Iphone X ", "35,000 (INR)", "China", getResources().getDrawable(R.drawable.i7)));
        itemListings.add(new ItemListing("Iphone SE Red", "57,668 (INR)", "India", getResources().getDrawable(R.drawable.i8)));


    }
}