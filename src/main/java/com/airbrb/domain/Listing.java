package com.airbrb.domain;

import java.util.Date;

public class Listing {
    private int id;
    private String title;
    private int owner;
    private float price;
    private boolean published;
    private Date postedOn;
    private String thumbnail;

    private Address address;

    @Override
    public String toString(){
        return "Listing{" +
                "id=" + id+ '\'' +
                ", title=" +title+ '\'' +
                ", price=" +price+ '\'' +
                ", address=" +address+ '\'' +
                ", owner=" +owner+ '\''+'}';
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
