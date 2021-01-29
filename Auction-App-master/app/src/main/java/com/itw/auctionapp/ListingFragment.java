package com.itw.auctionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itw.auctionapp.adapters.ListingAdapter;
import com.itw.auctionapp.databinding.ListingFragementBinding;
import com.itw.auctionapp.model.ItemListing;

import java.util.ArrayList;
import java.util.List;

public class ListingFragment extends Fragment {

    ListingFragementBinding listingFragementBinding;
    List<ItemListing> itemListings = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        listingFragementBinding = ListingFragementBinding.inflate(inflater, container, false);
        // adding items to the list
        itemListings.add(new ItemListing("Iphone 10", "4-10-20", "16-1--20", "15,000"));
        //
        setHasOptionsMenu(true);
        listingFragementBinding.textView2.setVisibility(View.VISIBLE);
        if (itemListings.isEmpty()) {
            listingFragementBinding.listingRecyclerView.setVisibility(View.GONE);
            listingFragementBinding.textView.setVisibility(View.VISIBLE);
            listingFragementBinding.tv2.setVisibility(View.VISIBLE);
            listingFragementBinding.textView2.setVisibility(View.GONE);
        }

        //recycler View
        ListingAdapter listingAdapter = new ListingAdapter(itemListings);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        listingFragementBinding.listingRecyclerView.setLayoutManager(linearLayoutManager);
        listingFragementBinding.listingRecyclerView.setAdapter(listingAdapter);
        //

        listingFragementBinding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //return fragment View
        return listingFragementBinding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.listing_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItemOption:
                Intent i = new Intent(getContext(), AddItemActivity.class);
                startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

}
