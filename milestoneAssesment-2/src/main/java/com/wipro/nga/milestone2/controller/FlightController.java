package com.wipro.nga.milestone2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wipro.nga.milestone2.exception.InvalidSearchRequestException;
import com.wipro.nga.milestone2.model.AirlinePrice;
import com.wipro.nga.milestone2.model.SearchRequest;
import com.wipro.nga.milestone2.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    @Autowired
    private BookingService bookingService;

    @Cacheable(value="cachedFlightsprice")
    @PostMapping("/search")
    public ResponseEntity<List<AirlinePrice>> searchFlights(@RequestBody SearchRequest request) {
        try {
            List<AirlinePrice> prices = bookingService.findFlightPrices(request);
            return new ResponseEntity<>(prices, HttpStatus.OK);
        } catch (InvalidSearchRequestException e) {
            throw e; // This will be handled by the global exception handler
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
