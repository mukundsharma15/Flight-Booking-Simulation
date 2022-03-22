package com.csci5308.group7.bookings.request;

import com.csci5308.group7.bookings.factory.AbstractBookingFactoryMock;
import com.csci5308.group7.bookings.interfaces.IRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class RequestTest {
    AbstractBookingFactoryMock bookingFactory = null;
    IRequest request = null;

    @BeforeEach
    void setUp() {
        bookingFactory = AbstractBookingFactoryMock.instance();
        request = bookingFactory.createRequest();
    }

    @AfterEach
    void tearDown() {
        bookingFactory = null;
        request = null;
    }


}
