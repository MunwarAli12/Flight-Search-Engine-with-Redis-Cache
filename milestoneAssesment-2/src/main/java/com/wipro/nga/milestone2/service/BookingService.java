package com.wipro.nga.milestone2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.nga.milestone2.exception.ErrorCode;
import com.wipro.nga.milestone2.exception.InvalidSearchRequestException;
import com.wipro.nga.milestone2.model.AirlinePrice;
import com.wipro.nga.milestone2.model.SearchRequest;

@Service
public class BookingService {

    @Autowired
    private BookingCache bookingCache;

    @Autowired
    private AirlineService airlineService;

    public List<AirlinePrice> findFlightPrices(SearchRequest request) {
        validateRequest(request);

        String key = bookingCache.generateKey(request);
        List<AirlinePrice> allPrices = bookingCache.getCachedQuotation(key);

        if (allPrices == null) {
            allPrices = airlineService.queryAirlines(request);
            bookingCache.saveQuotation(key, allPrices);
        }

        return allPrices;
    }

    private void validateRequest(SearchRequest request) {
        if (request.getReturnDate().isBefore(request.getDepartureDate())) {
            throw new InvalidSearchRequestException("Return date cannot be earlier than departure date.", ErrorCode.INVALID_REQUEST);
        }

        if (request.getOrigin().equalsIgnoreCase(request.getDestination())) {
            throw new InvalidSearchRequestException("Origin and destination cannot be the same.", ErrorCode.INVALID_REQUEST);
        }
    }
}
