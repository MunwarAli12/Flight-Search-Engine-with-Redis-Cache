package com.wipro.nga.milestone2.service;

import org.springframework.stereotype.Service;

import com.wipro.nga.milestone2.model.AirlinePrice;
import com.wipro.nga.milestone2.model.SearchRequest;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirlineService {

    public List<AirlinePrice> queryAirlines(SearchRequest request) {
        List<AirlinePrice> prices = new ArrayList<>();
        prices.add(new AirlinePrice("TATA Airlines", 28200.0));
        prices.add(new AirlinePrice("Emirates Airlines", 1250.0));
        prices.add(new AirlinePrice("Alaska Airlines", 1000.0));
        prices.add(new AirlinePrice("America Airlines", 1000.0));
        return prices;
    }
}