package com.wipro.nga.milestone2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import com.wipro.nga.milestone2.model.AirlinePrice;
import com.wipro.nga.milestone2.model.SearchRequest;
import java.util.List;

@Service
public class BookingCache {

    @Cacheable(value = "cachedFlightsprice", key = "#key")
    public List<AirlinePrice> getCachedQuotation(String key) {
        return null; // This will be managed by Redis
    }

    @CachePut(value = "cachedFlightsprice", key = "#key")
    public void saveQuotation(String key, List<AirlinePrice> prices) {
        // Redis will handle this
    }

    @CacheEvict(value = "cachedFlightsprice", key = "#key")
    public void evictQuotation(String key) {
        // Redis will handle this
    }

    public String generateKey(SearchRequest request) {
        return request.getOrigin() + ":" + request.getDestination() + ":" + request.getDepartureDate() + ":" + request.getReturnDate();
    }
}