package com.csci5308.group7.search.request;

import com.csci5308.group7.search.factory.AbstractSearchFactoryMock;
import com.csci5308.group7.search.interfaces.IRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RequestTest {

    AbstractSearchFactoryMock searchFactory = null;
    IRequest request = null;

    @BeforeEach
    void setUp() {
        searchFactory = AbstractSearchFactoryMock.instance();
        request = searchFactory.createRequest();
    }

    @AfterEach
    void tearDown() {
        searchFactory = null;
        request = null;
    }

    @Test
    void parseDepartureDay() {
        request.setDepartureDate("2015/09/23");
        assertEquals(23, request.parseDepartureDay());

        request.setDepartureDate("2015/09/02");
        assertEquals(2, request.parseDepartureDay());
    }

    @Test
    void parseDepartureMonth() {
        request.setDepartureDate("2015/09/23");
        assertEquals(9, request.parseDepartureMonth());

        request.setDepartureDate("2015/10/02");
        assertEquals(10, request.parseDepartureMonth());
    }

    @Test
    void parseReturnDay() {
        request.setReturnDate("2015/09/23");
        assertEquals(23, request.parseReturnDay());

        request.setReturnDate("2015/09/02");
        assertEquals(2, request.parseReturnDay());
    }

    @Test
    void parseReturnMonth() {
        request.setReturnDate("2015/09/23");
        assertEquals(9, request.parseReturnMonth());

        request.setReturnDate("2015/10/02");
        assertEquals(10, request.parseReturnMonth());
    }

    @Test
    void swapAirports() {
        request.setOrigin("SFO");
        request.setDestination("LAX");
        request.swapAirports();
        assertEquals("LAX", request.getOrigin());
        assertEquals("SFO", request.getDestination());

        request.setOrigin("ABE");
        request.setDestination("ALT");
        request.swapAirports();
        assertEquals("ALT", request.getOrigin());
        assertEquals("ABE", request.getDestination());
    }
}