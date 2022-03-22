package com.csci5308.group7.search;

import com.csci5308.group7.search.interfaces.*;

import java.util.HashMap;
import java.util.List;

public class Search implements ISearch {
    @Override
    public void searchFlight(IRequest searchRequest, ISearchModel searchModel, IResponse response) {

        List<HashMap<String, Object>> flights = searchModel.getFlights(searchRequest);

        if(searchRequest.getFlightType().equals(FlightType.ROUNDTRIP)) {
            searchRequest.swapAirports();
            List<HashMap<String, Object>> returnFlights = searchModel.getFlights(searchRequest);
            flights.addAll(returnFlights);
        }

        response.setResults(flights);
        response.setSuccess(true);
    }
}
