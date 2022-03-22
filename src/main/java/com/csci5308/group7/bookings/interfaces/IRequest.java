package com.csci5308.group7.bookings.interfaces;

public interface IRequest {

    public String getPNR();
    public void setPNR(String pnr);

    public String getLastName();
    public void setLastName(String lastname);

    public int getExtraBaggage();
    public void setExtraBaggage(int extraBaggage);

    public String getInsurance();
    public void setInsurance(String insurance);

    public String getFlightClass();
    public void setFlightClass(String flightClass);

    public int getNumberOfPassengers();
    public void setNumberOfPassengers(int numberOfPassengers);

    public String getSeatInformation();
    public void setSeatInformation(String seatInformation);

    public int getPrice();
    public void setPrice(int price);

    public int getUserId();
    public void setUserId(int userId);
}

