package com.itw.auctionapp.model;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class ItemListing implements Serializable {
    String name;
    String closingDate;
    String startingDate;
    String maximumBid;
    Drawable drawable;
    String country;

    public ItemListing(String name, String closingDate, String startingDate, String maximumBid) {
        this.name = name;
        this.closingDate = closingDate;
        this.startingDate = startingDate;
        this.maximumBid = maximumBid;
    }

    public ItemListing(String name, String maximumBid) {
        this.name = name;
        this.maximumBid = maximumBid;
    }

    public ItemListing(String name, String maximumBid, String country, Drawable drawable) {
        this.name = name;
        this.maximumBid = maximumBid;
        this.drawable = drawable;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(String closingDate) {
        this.closingDate = closingDate;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getMaximumBid() {
        return maximumBid;
    }

    public void setMaximumBid(String maximumBid) {
        this.maximumBid = maximumBid;
    }
}
