package com.csci5308.group7.bookings.model;

import com.csci5308.group7.bookings.interfaces.IManageBookingModel;
import com.csci5308.group7.bookings.interfaces.IRequest;
import com.csci5308.group7.search.FlightClass;
import com.csci5308.group7.search.FlightType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManageBookingModelMock implements IManageBookingModel {

    @Override
    public List<HashMap<String, Object>> bookings(IRequest bookingRequest){
        List<HashMap<String, Object>> bookings = new ArrayList<>();

        HashMap<String, Object> result1 = new HashMap<String, Object>();
        result1.put("insurance", "Y");
        result1.put("lastName", "Sharma");
        result1.put("origin", "New York");
        result1.put("destination", "Atlanta");
        result1.put("numberOfPessengers", 1);
        result1.put("extraBaggage", 1);
        result1.put("flightClass", FlightClass.ECONOMY);
        result1.put("flightType", FlightType.ROUNDTRIP);
        result1.put("bookingId", -2043404026);
        result1.put("airport", "LaGuardia Airport (Marine Air Terminal)");
        result1.put("flightNumber", "904");
        result1.put("firstName", "Mukund");
        result1.put("seatInformation", "23");
        result1.put("returnDate", "2015-01-01");
        result1.put("pnr", "1U2MOVEF");
        result1.put("price", 38260);
        result1.put("airlines", "Delta Air Lines Inc.");
        result1.put("userType", 3);
        result1.put("departureDate", "2015-01-01");
        bookings.add(result1);

        HashMap<String, Object> result2 = new HashMap<String, Object>();
        result2.put("insurance", "N");
        result2.put("lastName", "Sharma");
        result2.put("origin", "Atlanta");
        result2.put("destination", "New York");
        result2.put("numberOfPessengers", 3);
        result2.put("extraBaggage", 2);
        result2.put("flightClass", FlightClass.BUSINESS);
        result2.put("flightType", FlightType.ONE_WAY);
        result2.put("bookingId", -2043404026);
        result2.put("airport", "LaGuardia Airport (Marine Air Terminal)");
        result2.put("flightNumber", "904");
        result2.put("firstName", "Mukund");
        result2.put("seatInformation", "23");
        result2.put("returnDate", "2015-01-01");
        result2.put("pnr", "1U2MOVEF");
        result2.put("price", 38260);
        result2.put("airlines", "Delta Air Lines Inc.");
        result2.put("userType", 3);
        result2.put("departureDate", "2015-01-01");
        bookings.add(result2);

        HashMap<String, Object> result3 = new HashMap<String, Object>();
        result3.put("insurance", "Y");
        result3.put("lastName", "Sharma");
        result3.put("origin", "Atlanta");
        result3.put("destination", "New York");
        result3.put("numberOfPessengers", 10);
        result3.put("extraBaggage", 1);
        result3.put("flightClass", FlightClass.BUSINESS);
        result3.put("flightType", FlightType.ROUNDTRIP);
        result3.put("bookingId", -2043404026);
        result3.put("airport", "LaGuardia Airport (Marine Air Terminal)");
        result3.put("flightNumber", "904");
        result3.put("firstName", "Mukund");
        result3.put("seatInformation", "23");
        result3.put("returnDate", "2015-01-01");
        result3.put("pnr", "1U2MOVEF");
        result3.put("price", 38260);
        result3.put("airlines", "Delta Air Lines Inc.");
        result3.put("userType", 3);
        result3.put("departureDate", "2015-01-01");
        bookings.add(result3);


        return bookings;
    }

    @Override
    public boolean editBooking(IRequest bookingRequest){
        return true;
    }

    @Override
    public boolean deleteBooking(IRequest bookingRequest){
        return true;
    }

}
