package com.csci5308.group7.search.interfaces;

import com.csci5308.group7.search.FlightClass;
import com.csci5308.group7.search.FlightType;

public interface IRequest {
    public String getOrigin();

    public void setOrigin(String origin);

    public String getDestination();

    public void setDestination(String destination);

    public String getDepartureDate();

    public void setDepartureDate(String departureDate);

    public String getReturnDate();

    public void setReturnDate(String returnDate);

    public int getNumberOfPassengers();

    public void setNumberOfPassengers(int numberOfPassengers);

    public FlightClass getFlightClass();

    public void setFlightClass(FlightClass flightClass);

    public FlightType getFlightType();

    public void setFlightType(FlightType flightType);

    public int parseDepartureDay();

    public int parseDepartureMonth();

    public int parseReturnDay();

    public int parseReturnMonth();

    public void swapAirports();

    public int getCallingUserId();

    public void setCallingUserId(int callingUserId);

}
