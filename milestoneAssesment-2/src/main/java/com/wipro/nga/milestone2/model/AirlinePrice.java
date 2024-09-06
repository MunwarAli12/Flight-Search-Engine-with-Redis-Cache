package com.wipro.nga.milestone2.model;

public class AirlinePrice {

    private String airlineName;
    private double price;

    public AirlinePrice(String airlineName, double price) {
        this.airlineName = airlineName;
        this.price = price;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
