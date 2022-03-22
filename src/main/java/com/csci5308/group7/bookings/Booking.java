package com.csci5308.group7.bookings;

import com.csci5308.group7.bookings.interfaces.*;

import java.util.HashMap;
import java.util.List;

public class Booking implements IBooking {

    @Override
    public void getBookings(IRequest bookingRequest, IManageBookingModel bookingModel, IResponse response){

        List<HashMap<String, Object>> flightBookings = bookingModel.bookings(bookingRequest);
        response.setResults(flightBookings);
        response.setResults(flightBookings);
        response.setSuccess(true);
    }

    @Override
    public void editBooking(IRequest editRequest, IManageBookingModel bookingModel, IResponse response){
        boolean editResponse = bookingModel.editBooking(editRequest);
        response.setSuccess(editResponse);
    }

    @Override
    public void deleteBooking(IRequest editRequest, IManageBookingModel bookingModel, IResponse response){
        boolean deleteResponse = bookingModel.deleteBooking(editRequest);
        response.setSuccess(deleteResponse);
    }
}
