package com.itw.auctionapp.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itw.auctionapp.databinding.ListingItemBinding;
import com.itw.auctionapp.model.ItemListing;

import java.util.ArrayList;
import java.util.List;

public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ViewHolder> {

    public ListingAdapter(List<ItemListing> itemListings) {
        this.itemListings = itemListings;
    }

    List<ItemListing> itemListings = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ListingItemBinding itemBinding = ListingItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemBinding.itemName.setText(itemListings.get(position).getName());
        holder.itemBinding.closingDate.setText(itemListings.get(position).getClosingDate());
    }

    @Override
    public int getItemCount() {
        return itemListings.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ListingItemBinding itemBinding;

        public ViewHolder(ListingItemBinding binding) {
            super(binding.getRoot());
            this.itemBinding = binding;
        }
    }
}
