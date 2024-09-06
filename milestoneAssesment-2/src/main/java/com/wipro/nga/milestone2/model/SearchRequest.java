package com.wipro.nga.milestone2.model;


import java.time.LocalDate;

public class SearchRequest {

    private String origin;
    private String destination;
    private LocalDate departureDate;
    private LocalDate returnDate;


    public SearchRequest(String origin, String destination, LocalDate departureDate, LocalDate returnDate) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
    }

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

    
}
