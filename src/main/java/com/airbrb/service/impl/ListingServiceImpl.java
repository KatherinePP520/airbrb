package com.airbrb.service.impl;

import com.airbrb.dao.AddressDao;
import com.airbrb.dao.ListingDao;
import com.airbrb.domain.Listing;
import com.airbrb.domain.ListingId;
import com.airbrb.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingDao listingDao;
    @Autowired
    private AddressDao addressDao;
    @Override
    public ListingId create(Listing listing) {
        listing.setOwner(1);
        System.out.println(listing);
        listingDao.create(listing);
        int listingId = listing.getId();
        System.out.println(listing.getId());
        listing.getAddress().setId(listingId);
        System.out.println(listing.getAddress());
        addressDao.create(listing.getAddress());
        return new ListingId(listingId);
    }

    public List<Listing> getAll() {
        List<Listing> result =  listingDao.getAll();
        System.out.println(result);
        return result;
    }
}
