package com.csci5308.group7.search;

import com.csci5308.group7.search.interfaces.IFareCalculator;
import com.csci5308.group7.search.interfaces.IRequest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class FareCalculator implements IFareCalculator {
    private FlightClass flightClass;
    private int economyClass;
    private int businessClass;
    private int firstClass;
    private int flightCapacity;
    private double price;
    private double discount;
    String userType;
    @Override
    public double multiplyingFactor(int ClassSeats,int ClassCapacity){
        int ratio = (int) Math.floor(((double)ClassSeats/(double) ClassCapacity)*100);
        if( ratio >= 0 && ratio <= 9){
            return 1.0;

        }
        else if(ratio >= 10 && ratio <= 19) {
            return 1.1;

        }
        else if(ratio >= 20 && ratio <= 29) {
            return 1.2;

        }
        else if(ratio >= 30 && ratio <= 39) {
            return 1.3;

        }
        else if(ratio >= 40 && ratio <= 49) {
            return 1.4;

        }
        else if(ratio >= 50 && ratio <= 59) {
            return 1.5;

        }
        else if(ratio >= 60 && ratio <= 69) {
            return 1.6;

        }
        else if(ratio >= 70 && ratio <= 79) {
            return 1.7;

        }
        else if(ratio >= 80 && ratio <= 89) {
            return 1.8;

        }
        else if(ratio >= 90 && ratio <= 99) {
            return 2.0;

        }
        else{
            return -1.0;
        }
    }
    @Override
    public double dynamicfare(Map<String, Object> result, IRequest searchRequest){
        double dynamicFare = 0.0;
        userType = "Airlines";
//        price = result.getPrice();
        price = 45000;
        String flightCategory=null;
        double multiplyingFactor = 1.0;
        flightClass = searchRequest.getFlightClass();
        int flightCapacity = (int) result.get("flightCapacity");

        if(flightClass == FlightClass.ECONOMY){
            int economyClass = (int) result.get("economyClass");
            multiplyingFactor = multiplyingFactor(economyClass,(int)Math.floor(0.6*flightCapacity));
            flightCategory = "ECONOMY";

        }
        else if(flightClass == FlightClass.BUSINESS){
            int businessClass = (int) result.get("businessClass");
            multiplyingFactor = multiplyingFactor(businessClass,(int)Math.floor(0.3*flightCapacity));
            flightCategory = "BUISNESS";
            price = price*3;
        }
        else if(flightClass == FlightClass.FIRST){
            int firstClass = (int) result.get("firstClass");
            multiplyingFactor = multiplyingFactor(firstClass,(int)Math.floor(0.1*flightCapacity));
            flightCategory = "FIRST";
            price = price*4;
        }
        userType = "Airlines";
        switch(userType){
            case "Airlines":    discount = 0.15;
                                break;
            case "Customer":    discount = 0;
                                break;
            case "Travel Agent":    discount = 0.1;
                                    break;
            default:    break;
        }

        if(multiplyingFactor==-1.0){
            System.out.println("All seats are taken");
        }
        else{
            double temp = (1-discount)*multiplyingFactor*price;
            dynamicFare = BigDecimal.valueOf(temp).setScale(2, RoundingMode.FLOOR).doubleValue();


        }

        return dynamicFare;
    }

}
