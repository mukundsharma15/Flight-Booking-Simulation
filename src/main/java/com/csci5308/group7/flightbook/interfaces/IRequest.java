package com.csci5308.group7.flightbook.interfaces;


public interface IRequest {
    public String getAirlines();

    public void setAirlines(String airlines);

    public String getAirport();

    public void setAirport(String airport);

    public String getFlightNumber();

    public void setFlightNumber(String flightNumber);

    public int getPrice();

    public void setPrice(int price);

    public int getUserId();

    public void setUserId(int userId);

    public int getUserType();

    public void setUserType(int userType);

    public String getFirstName();

    public void setFirstName(String firstName);

    public int getExtraBaggage();

    public void setExtraBaggage(int extraBaggage);

    public String getValidProofID();

    public void setValidProofID(String validProofID);

    public int getSeatInformation();

    public void setSeatInformation(int seatInformation);

    public String getInsurance();

    public void setInsurance(String insurance);

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

    public String getFlightClass();

    public void setFlightClass(String flightClass);

    public String getFlightType();

    public void setFlightType(String flightType);

    public String getLastName();

    public void setLastName(String lastName);

//    public int parseReturnDay();
//
//    public int parseReturnMonth();
//
//    public void swapAirports();
}
