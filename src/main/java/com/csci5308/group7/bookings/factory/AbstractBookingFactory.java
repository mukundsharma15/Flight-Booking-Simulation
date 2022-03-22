package com.csci5308.group7.bookings.factory;

import com.csci5308.group7.bookings.interfaces.*;

public abstract class AbstractBookingFactory {
    private static AbstractBookingFactory instance = null;

    protected AbstractBookingFactory() {
    }

    public static AbstractBookingFactory instance() {
        if (instance == null) {
            instance = new BookingFactory();
        }
        return instance;
    }

    public abstract IBooking getBooking();
    public abstract IManageBookingModel createBookingModel();
    public abstract IRequest createRequest();
    public abstract IResponse createResponse();
}
