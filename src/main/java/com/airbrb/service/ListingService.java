package com.airbrb.service;

import com.airbrb.domain.Listing;
import com.airbrb.domain.ListingId;

import java.util.List;

public interface ListingService {

    public ListingId create(Listing listing);

    public List<Listing> getAll();

}
