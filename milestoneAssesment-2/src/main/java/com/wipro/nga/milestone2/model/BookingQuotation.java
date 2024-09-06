package com.wipro.nga.milestone2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "bookingQuotations")
public class BookingQuotation implements Serializable {

    @Id
    private String id; // Use String for MongoDB ObjectId or custom key
    private SearchRequest searchRequest;
    private List<AirlinePrice> prices;

    public BookingQuotation(String id, SearchRequest searchRequest, List<AirlinePrice> prices) {
        this.id = id;
        this.searchRequest = searchRequest;
        this.prices = prices;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    public void setSearchRequest(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    public List<AirlinePrice> getPrices() {
        return prices;
    }

    public void setPrices(List<AirlinePrice> prices) {
        this.prices = prices;
    }
}
