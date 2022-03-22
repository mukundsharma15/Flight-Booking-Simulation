package com.csci5308.group7.bookings.interfaces;

import java.util.HashMap;
import java.util.List;

public interface IManageBookingModel {
    public List<HashMap<String, Object>> bookings(IRequest bookingRequest);
    public boolean editBooking(IRequest bookingRequest);
    public boolean deleteBooking(IRequest bookingRequest);
}
