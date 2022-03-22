package com.csci5308.group7.bookings.interfaces;


public interface IBooking {
    public void getBookings(IRequest bookingRequest, IManageBookingModel bookingModel, IResponse response);
    public void editBooking(IRequest bookingRequest, IManageBookingModel bookingModel, IResponse response);
    public void deleteBooking(IRequest bookingRequest, IManageBookingModel bookingModel, IResponse response);
}
