package com.airbrb.controller;

import com.airbrb.domain.Listing;
import com.airbrb.domain.ListingId;
import com.airbrb.domain.Token;
import com.airbrb.domain.User;
import com.airbrb.service.ListingService;
import com.airbrb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
@RequestMapping("/listings")
public class ListingController {

    @Autowired
    private ListingService listingService;

    @PostMapping("/new")
    public ResponseEntity create(@RequestBody Listing listing) {
        ListingId data = listingService.create(listing);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(APPLICATION_JSON)
                .body(data);
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<Listing> data = listingService.getAll();
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(APPLICATION_JSON)
                .body(data);
    }
}
