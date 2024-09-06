package com.wipro.nga.milestone2.BookingServiceTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wipro.nga.milestone2.exception.InvalidSearchRequestException;
import com.wipro.nga.milestone2.model.AirlinePrice;
import com.wipro.nga.milestone2.model.SearchRequest;
import com.wipro.nga.milestone2.service.BookingService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookingServiceTests {

    @Autowired
    private BookingService bookingService;
    
    
    @Test
    public void testFindFlightPricesCached() {
        SearchRequest request = new SearchRequest("MUMBAI", "NASIK", LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 5));
        List<AirlinePrice> prices = bookingService.findFlightPrices(request);
        assertEquals(4, prices.size());  
        
        // Test caching by calling again
        List<AirlinePrice> cachedPrices = bookingService.findFlightPrices(request);
        assertEquals(4, cachedPrices.size());  
    }


    @Test
    public void testFindFlightPrices() {
        SearchRequest request = new SearchRequest("MUMBAI", "NASIK", LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 5));
        List<AirlinePrice> prices = bookingService.findFlightPrices(request);
        assertEquals(4, prices.size());  
    }

    @Test
    public void testFindFlightPricesWithSameOriginAndDestination() {
        SearchRequest request = new SearchRequest("NYC", "NYC", LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 5));
        assertThrows(InvalidSearchRequestException.class, () -> {
            bookingService.findFlightPrices(request);
        });
    }

    @Test
    public void testFindFlightPricesWithReturnDateBeforeDepartureDate() {
        SearchRequest request = new SearchRequest("IND", "NYC", LocalDate.of(2024, 9, 5),
                LocalDate.of(2024, 9, 1));
        assertThrows(InvalidSearchRequestException.class, () -> {
            bookingService.findFlightPrices(request);
        });
    }

    @Test
    public void testFindFlightPricesWithValidRequestCached() {
        SearchRequest request = new SearchRequest("IND", "NYC", LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 5));
        bookingService.findFlightPrices(request);

        List<AirlinePrice> cachedPrices = bookingService.findFlightPrices(request);
        assertEquals(4, cachedPrices.size());  
    }

    @Test
    public void testFindFlightPricesWithValidRequestNotCached() {
        SearchRequest request = new SearchRequest("LAX", "ORD", LocalDate.of(2024, 10, 1),
                LocalDate.of(2024, 10, 5));

        List<AirlinePrice> prices = bookingService.findFlightPrices(request);
        assertEquals(4, prices.size());  
    }
}