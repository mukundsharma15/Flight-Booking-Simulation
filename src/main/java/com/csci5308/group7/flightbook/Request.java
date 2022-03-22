package com.csci5308.group7.flightbook;

import com.csci5308.group7.flightbook.interfaces.IRequest;


public class Request implements IRequest {

    private int userId;
    private int userType;
    private String firstName;
    private String lastName;
    private String airlines;
    private String airport;
    private String flightNumber;
    private int price;
    private int extraBaggage;
    private String validProofID;
    private int seatInformation;
    private String insurance;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int numberOfPassengers;
    private String flightClass;
    private String flightType;

    public Request(){
        // default implementation ignored
    }

    public int getExtraBaggage() {
        return extraBaggage;
    }

    public void setExtraBaggage(int extraBaggage) {
        this.extraBaggage = extraBaggage;
    }

    public String getValidProofID() {
        return validProofID;
    }

    public void setValidProofID(String validProofID) {
        this.validProofID = validProofID;
    }

    public int getSeatInformation() {
        return seatInformation;
    }

    public void setSeatInformation(int seatInformation) {
        this.seatInformation = seatInformation;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
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

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getFlightType() {
        return flightType;
    }

    public void setFlightType(String flightType) {
        this.flightType = flightType;
    }

    public String getAirlines() {
        return airlines;
    }

    public void setAirlines(String airlines) {
        this.airlines = airlines;
    }

    public String getAirport() {
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
