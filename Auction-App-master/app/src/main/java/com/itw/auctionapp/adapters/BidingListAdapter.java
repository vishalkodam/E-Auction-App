package com.itw.auctionapp.adapters;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itw.auctionapp.databinding.ListItemBiddingBinding;
import com.itw.auctionapp.model.ItemListing;

import java.util.ArrayList;
import java.util.List;

public class BidingListAdapter extends RecyclerView.Adapter<BidingListAdapter.ViewHolder> {

    List<ItemListing> itemListings = new ArrayList<>();

    public BidingListAdapter(List<ItemListing> itemListings) {
        this.itemListings = itemListings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListItemBiddingBinding itemBiddingBinding = ListItemBiddingBinding.inflate(layoutInflater);
        return new ViewHolder(itemBiddingBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.listItemBiddingBinding.img.setImageDrawable(itemListings.get(position).getDrawable());
        holder.listItemBiddingBinding.itemName.setText(itemListings.get(position).getName());
        holder.listItemBiddingBinding.country.setText(itemListings.get(position).getCountry());
        holder.listItemBiddingBinding.currentValue.setText(itemListings.get(position).getMaximumBid());
    }

    @Override
    public int getItemCount() {
        return itemListings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBiddingBinding listItemBiddingBinding;

        public ViewHolder(ListItemBiddingBinding binding) {
            super(binding.getRoot());
            this.listItemBiddingBinding = binding;
        }
    }
}
