package com.csci5308.group7.bookings;

import com.csci5308.group7.bookings.interfaces.IRequest;

public class Request implements IRequest {
    private String pnr;
    private String lastname;
    private int extraBaggage;
    private String insurance;
    private String flightClass;
    private int noOfPassengers;
    private String seatInfo;
    private int price;
    private int userId;

    public Request(){}

    public Request(String pnr, String lastname, int extraBaggage, String insurance, String flightClass,
                   int noOfPassengers, String seatInfo, int price, int userId){
        this.pnr = pnr;
        this.lastname = lastname;
        this.extraBaggage = extraBaggage;
        this.insurance = insurance;
        this.flightClass = flightClass;
        this.noOfPassengers = noOfPassengers;
        this.seatInfo = seatInfo;
        this.price = price;
        this.userId = userId;
    }

    public String getPNR(){
        return pnr;
    }

    public void setPNR(String pnr){
        this.pnr=pnr;
    }

    public String getLastName(){
        return lastname;
    }

    public void setLastName(String lastname){
        this.lastname = lastname;
    }

    @Override
    public int getExtraBaggage() {
        return extraBaggage;
    }

    @Override
    public void setExtraBaggage(int extraBaggage) {
        this.extraBaggage = extraBaggage;
    }

    @Override
    public String getInsurance() {
        return insurance;
    }

    @Override
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    @Override
    public String getFlightClass() {
        return flightClass;
    }

    @Override
    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public int getNumberOfPassengers() {
        return noOfPassengers;
    }

    @Override
    public void setNumberOfPassengers(int numberOfPassengers) {
        this.noOfPassengers = numberOfPassengers;
    }

    @Override
    public String getSeatInformation() {
        return seatInfo;
    }

    @Override
    public void setSeatInformation(String seatInformation) {
        this.seatInfo = seatInformation;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
}
