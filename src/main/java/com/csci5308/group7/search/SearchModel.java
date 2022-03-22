package com.csci5308.group7.search;

import com.csci5308.group7.database.DBConnection;
import com.csci5308.group7.database.IDBConnection;
import com.csci5308.group7.search.abstractfactory.AbstractSearchFactory;
import com.csci5308.group7.search.interfaces.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SearchModel implements ISearchModel {

    public static SearchModel singleInstance = null;
    IDBConnection dbConnection = DBConnection.instance();
    AbstractSearchFactory searchFactory = AbstractSearchFactory.instance();
    IFareCalculator fareCalculator = searchFactory.createFareCalculator();

    public static ISearchModel instance() {
        if (null == singleInstance) {
            singleInstance = new SearchModel();
        }
        return singleInstance;
    }

    public List<HashMap<String, Object>> getFlights(IRequest searchRequest) {

        Connection connection = dbConnection.createConnection();
        List<HashMap<String, Object>> results= new ArrayList<>();

        try {

            String originAirportCode = null;
            String destinationAirportCode = null;

            String airportCodeQuery = "SELECT airport_id, city FROM `5308_Airports` WHERE city = ? OR city = ?";
            PreparedStatement airportCodeStatement = connection.prepareStatement(airportCodeQuery);
            airportCodeStatement.setString(1, searchRequest.getOrigin());
            airportCodeStatement.setString(2, searchRequest.getDestination());
            ResultSet airportCodeResult =  airportCodeStatement.executeQuery();

            while (airportCodeResult.next()) {
                if(airportCodeResult.getString("city").equals(searchRequest.getOrigin())) {
                    originAirportCode = airportCodeResult.getString("airport_id");
                }

                if(airportCodeResult.getString("city").equals(searchRequest.getDestination())) {
                    destinationAirportCode = airportCodeResult.getString("airport_id");
                }
            }

            String flightToQuery = "SELECT * FROM `5308_FlightSchedule` a LEFT JOIN `5308_Airlines` b ON a.`AIRLINE` = b.airlineId LEFT JOIN `5308_Airports` c ON a.`ORIGIN_AIRPORT` = c.airport_id WHERE ORIGIN_AIRPORT = ? AND DESTINATION_AIRPORT = ? AND MONTH = ? AND DAY = ?";
            PreparedStatement flightToStatement = connection.prepareStatement(flightToQuery);
            flightToStatement.setString(1, originAirportCode);
            flightToStatement.setString(2, destinationAirportCode);
            flightToStatement.setInt(3, searchRequest.parseDepartureMonth());
            flightToStatement.setInt(4, searchRequest.parseDepartureDay());

            ResultSet flightToResult = flightToStatement.executeQuery();

            while (flightToResult.next()) {

                HashMap<String, Object> searchResult = new HashMap<String, Object>();
                searchResult.put("id", flightToResult.getInt("id"));
                searchResult.put("airlines", flightToResult.getString("name"));
                searchResult.put("airport", flightToResult.getString("airport"));
                searchResult.put("flightNumber", flightToResult.getString("FLIGHT_NUMBER"));
                searchResult.put("flightDuration", flightToResult.getInt("AIR_TIME"));
                searchResult.put("departureTime", flightToResult.getInt("DEPARTURE_TIME"));
                searchResult.put("arrivalTime", flightToResult.getInt("SCHEDULED_ARRIVAL"));
                searchResult.put("departureDate", searchRequest.getDepartureDate());
                searchResult.put("arrivalDate", searchRequest.getDepartureDate());
                searchResult.put("facilities", null);
                searchResult.put("flightType", searchRequest.getFlightType());
                searchResult.put("flightClass", searchRequest.getFlightClass());
                searchResult.put("flightCapacity", 150);
                searchResult.put("economyClass", 0);
                searchResult.put("businessClass", 0);
                searchResult.put("firstClass", 0);

                double fare = fareCalculator.dynamicfare(searchResult, searchRequest);
                searchResult.put("price", fare);

                results.add(searchResult);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return results;
    }
}
