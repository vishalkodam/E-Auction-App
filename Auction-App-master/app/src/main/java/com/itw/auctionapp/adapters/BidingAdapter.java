package com.itw.auctionapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itw.auctionapp.databinding.ItemBidBinding;
import com.itw.auctionapp.model.ItemListing;

import java.util.ArrayList;
import java.util.List;

public class BidingAdapter extends RecyclerView.Adapter<BidingAdapter.MyViewHolder> {
    List<ItemListing> itemListings = new ArrayList<>();

    public BidingAdapter(List<ItemListing> itemListings) {
        this.itemListings = itemListings;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemBidBinding itemBidBinding = ItemBidBinding.inflate(layoutInflater, parent, false);
        return new MyViewHolder(itemBidBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.itemBidBinding.userNameList.setText(itemListings.get(position).getName());
        holder.itemBidBinding.bidAmount.setText(itemListings.get(position).getMaximumBid());
    }

    @Override
    public int getItemCount() {
        return itemListings.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ItemBidBinding itemBidBinding;

        public MyViewHolder(ItemBidBinding binding) {
            super(binding.getRoot());
            this.itemBidBinding = binding;
        }
    }
}
