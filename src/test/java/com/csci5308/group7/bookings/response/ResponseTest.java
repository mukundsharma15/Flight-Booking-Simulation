package com.csci5308.group7.bookings.response;

import com.csci5308.group7.bookings.factory.AbstractBookingFactoryMock;
import com.csci5308.group7.bookings.interfaces.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseTest {
    AbstractBookingFactoryMock bookingFactoryMock = null;
    IResponse response = null;
    IManageBookingModel bookingModel = null;
    IRequest bookingRequest = null;

    String TEST_RESPONSE = "{\"success\":true,\"results\":[{\"insurance\":\"Y\",\"lastName\":\"Sharma\",\"origin\":\"New York\",\"destination\":\"Atlanta\",\"numberOfPessengers\":1,\n" +
            "\"extraBaggage\":1,\"flightClass\":\"ECONOMY\",\"flightType\":\"ROUNDTRIP\",\"bookingId\":-2043404026,\"airport\":\"LaGuardia Airport (Marine Air Terminal)\",\n" +
            "\"flightNumber\":\"904\",\"firstName\":\"Mukund\",\"seatInformation\":\"23\",\"returnDate\":\"2015-01-01\",\"pnr\":\"1U2MOVEF\",\"price\":38260,\n" +
            "\"airlines\":\"Delta Air Lines Inc.\",\"userType\":3,\"departureDate\":\"2015-01-01\"},{\"insurance\":\"N\",\"lastName\":\"Sharma\",\"origin\":\"New York\",\"destination\":\"Atlanta\",\"numberOfPessengers\":3,\n" +
            "\"extraBaggage\":2,\"flightClass\":\"BUSINESS\",\"flightType\":\"ONE_WAY\",\"bookingId\":-2043404026,\"airport\":\"LaGuardia Airport (Marine Air Terminal)\",\n" +
            "\"flightNumber\":\"904\",\"firstName\":\"Mukund\",\"seatInformation\":\"23\",\"returnDate\":\"2015-01-01\",\"pnr\":\"1U2MOVEF\",\"price\":38260,\n" +
            "\"airlines\":\"Delta Air Lines Inc.\",\"userType\":3,\"departureDate\":\"2015-01-01\"},{\"insurance\":\"Y\",\"lastName\":\"Sharma\",\"origin\":\"New York\",\"destination\":\"Atlanta\",\"numberOfPessengers\":10,\n" +
            "\"extraBaggage\":1,\"flightClass\":\"BUSINESS\",\"flightType\":\"ROUNDTRIP\",\"bookingId\":-2043404026,\"airport\":\"LaGuardia Airport (Marine Air Terminal)\",\n" +
            "\"flightNumber\":\"904\",\"firstName\":\"Mukund\",\"seatInformation\":\"23\",\"returnDate\":\"2015-01-01\",\"pnr\":\"1U2MOVEF\",\"price\":38260,\n" +
            "\"airlines\":\"Delta Air Lines Inc.\",\"userType\":3,\"departureDate\":\"2015-01-01\"}]}";

    @BeforeEach
    void setUp() {
        bookingFactoryMock = AbstractBookingFactoryMock.instance();
        response = bookingFactoryMock.createResponse();
        bookingModel = bookingFactoryMock.createBookingModel();
        bookingRequest = bookingFactoryMock.createRequest();
    }

    @AfterEach
    void tearDown() {
        bookingFactoryMock = null;
        response = null;
    }

    @Test
    void testToString() {
        List<HashMap<String, Object>> results = bookingModel.bookings(bookingRequest);
        assertEquals(3, results.size());
        response.setResults(results);
        response.setSuccess(true);
        assertEquals(TEST_RESPONSE, response.toString());
    }

    @Test
    void appendResults() {
        List<HashMap<String, Object>> results1 = bookingModel.bookings(bookingRequest);
        List<HashMap<String, Object>> results2 = bookingModel.bookings(bookingRequest);
        response.setResults(results1);
        response.appendResults(results2);
        response.setSuccess(true);
        assertEquals(6, response.getResults().size());
    }
}
