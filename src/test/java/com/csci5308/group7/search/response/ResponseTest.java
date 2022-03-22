package com.csci5308.group7.search.response;

import com.csci5308.group7.search.factory.AbstractSearchFactoryMock;
import com.csci5308.group7.search.interfaces.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResponseTest {

    AbstractSearchFactoryMock searchFactoryMock = null;
    IResponse response = null;
    ISearchModel searchModel = null;
    IRequest searchRequest = null;

    String TEST_RESPONSE = "{\"success\":true,\"results\":[{\"departureTime\":1200,\"flightClass\":\"BUSINESS\",\"flightType\":\"ONE_WAY\",\"airport\":\"Toronto\",\"flightNumber\":\"123\",\"arrivalDate\":\"2019-10-10\",\"price\":100,\"arrivalTime\":1330,\"flightDuration\":290,\"airlines\":\"Air Canada\",\"id\":1,\"departureDate\":\"2019-10-10\",\"facilities\":null},{\"departureTime\":1200,\"flightClass\":\"ECONOMY\",\"flightType\":\"ONE_WAY\",\"airport\":\"San Francisco\",\"flightNumber\":\"889\",\"arrivalDate\":\"2019-10-10\",\"price\":100,\"arrivalTime\":1330,\"flightDuration\":290,\"airlines\":\"Air Canada\",\"id\":2,\"departureDate\":\"2019-10-10\",\"facilities\":null},{\"departureTime\":1200,\"flightClass\":\"BUSINESS\",\"flightType\":\"ROUNDTRIP\",\"airport\":\"Halifax\",\"flightNumber\":\"123\",\"arrivalDate\":\"2019-10-10\",\"price\":100,\"arrivalTime\":1330,\"flightDuration\":290,\"airlines\":\"Air Canada\",\"id\":3,\"departureDate\":\"2019-10-10\",\"facilities\":null}]}";

    @BeforeEach
    void setUp() {
        searchFactoryMock = AbstractSearchFactoryMock.instance();
        response = searchFactoryMock.createResponse();
        searchModel = searchFactoryMock.createSearchModel();
        searchRequest = searchFactoryMock.createRequest();
    }

    @AfterEach
    void tearDown() {
        searchFactoryMock = null;
        response = null;
    }

    @Test
    void testToString() {
        List<HashMap<String, Object>> results = searchModel.getFlights(searchRequest);

        assertEquals(3, results.size());

        response.setResults(results);
        response.setSuccess(true);

        assertEquals(TEST_RESPONSE, response.toString());
    }

    @Test
    void appendResults() {
        List<HashMap<String, Object>> results1 = searchModel.getFlights(searchRequest);
        List<HashMap<String, Object>> results2 = searchModel.getFlights(searchRequest);

        response.setResults(results1);
        response.appendResults(results2);
        response.setSuccess(true);

        assertEquals(6, response.getResults().size());
    }
}