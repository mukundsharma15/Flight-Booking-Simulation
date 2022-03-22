package com.csci5308.group7.search.model;

import com.csci5308.group7.search.FlightClass;
import com.csci5308.group7.search.FlightType;
import com.csci5308.group7.search.interfaces.ISearchModel;
import com.csci5308.group7.search.interfaces.IRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchModelMock implements ISearchModel {

    @Override
    public List<HashMap<String, Object>> getFlights(IRequest searchRequest) {

        List<HashMap<String, Object>> flights = new ArrayList<>();

        HashMap<String, Object> result1 = new HashMap<String, Object>();

        result1.put("id", 1);
        result1.put("airlines", "Air Canada");
        result1.put("airport", "Toronto");
        result1.put("flightNumber", "123");
        result1.put("price", 100);
        result1.put("flightDuration", 290);
        result1.put("departureTime", 1200);
        result1.put("arrivalTime", 1330);
        result1.put("departureDate", "2019-10-10");
        result1.put("arrivalDate", "2019-10-10");
        result1.put("facilities", null);
        result1.put("flightType", FlightType.ONE_WAY);
        result1.put("flightClass", FlightClass.BUSINESS);
        flights.add(result1);

        HashMap<String, Object> result2 = new HashMap<String, Object>();

        result2.put("id", 2);
        result2.put("airlines", "Air Canada");
        result2.put("airport", "San Francisco");
        result2.put("flightNumber", "889");
        result2.put("price", 100);
        result2.put("flightDuration", 290);
        result2.put("departureTime", 1200);
        result2.put("arrivalTime", 1330);
        result2.put("departureDate", "2019-10-10");
        result2.put("arrivalDate", "2019-10-10");
        result2.put("facilities", null);
        result2.put("flightType", FlightType.ONE_WAY);
        result2.put("flightClass", FlightClass.ECONOMY);
        flights.add(result2);

        HashMap<String, Object> result3 = new HashMap<String, Object>();

        result3.put("id", 3);
        result3.put("airlines", "Air Canada");
        result3.put("airport", "Halifax");
        result3.put("flightNumber", "123");
        result3.put("price", 100);
        result3.put("flightDuration", 290);
        result3.put("departureTime", 1200);
        result3.put("arrivalTime", 1330);
        result3.put("departureDate", "2019-10-10");
        result3.put("arrivalDate", "2019-10-10");
        result3.put("facilities", null);
        result3.put("flightType", FlightType.ROUNDTRIP);
        result3.put("flightClass", FlightClass.BUSINESS);
        flights.add(result3);

        return flights;
    }
}
