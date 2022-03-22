package com.csci5308.group7.search;

import com.csci5308.group7.search.interfaces.IRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Request implements IRequest {
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfPassengers;
    private FlightClass flightClass;
    private FlightType flightType;
    private int callingUserId;

    private final SimpleDateFormat parser = new SimpleDateFormat("yyyy/MM/dd");
    private Date date = null;

    public Request() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public FlightClass getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(FlightClass flightClass) {
        this.flightClass = flightClass;
    }

    public FlightType getFlightType() {
        return flightType;
    }

    public void setFlightType(FlightType flightType) {
        this.flightType = flightType;
    }

    public int getCallingUserId() {
        return callingUserId;
    }

    public void setCallingUserId(int callingUserId) {
        this.callingUserId = callingUserId;
    }

    @Override
    public int parseDepartureDay() {
        String formattedDate = null;
        try {
            date = parser.parse(this.getDepartureDate());
            SimpleDateFormat formatter = new SimpleDateFormat("dd");
            formattedDate = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(formattedDate);
    }

    @Override
    public int parseDepartureMonth() {
        String formattedDate = null;
        try {
            date = parser.parse(this.getDepartureDate());
            SimpleDateFormat formatter = new SimpleDateFormat("MM");
            formattedDate = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(formattedDate);
    }

    @Override
    public int parseReturnDay() {
        String formattedDate = null;
        try {
            date = parser.parse(this.getReturnDate());
            SimpleDateFormat formatter = new SimpleDateFormat("dd");
            formattedDate = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(formattedDate);
    }

    @Override
    public int parseReturnMonth() {
        String formattedDate = null;
        try {
            date = parser.parse(this.getReturnDate());
            SimpleDateFormat formatter = new SimpleDateFormat("MM");
            formattedDate = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(formattedDate);
    }

    public void swapAirports() {
        String temp = this.origin;
        this.origin = this.destination;
        this.destination = temp;
    }
}
