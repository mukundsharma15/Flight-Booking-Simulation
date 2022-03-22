package com.csci5308.group7.bookings;

import com.csci5308.group7.bookings.interfaces.IManageBookingModel;
import com.csci5308.group7.bookings.interfaces.IRequest;
import com.csci5308.group7.database.DBConnection;
import com.csci5308.group7.database.IDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManageBookingModel implements IManageBookingModel {

    //constants
    public static final String FLIGHT_BOOKING = "5308_FlightBooking";
    public static final int BASE_PRICE = 38250;
    public static final int EXTRA_BAGGAGE_PRICE = 2000;
    public static final int INSURANCE_PRICE = 1500;
    public static final int BUSINESS_CLASS_CHARGES = 20000;
    public static ManageBookingModel singleInstance = null;

    IDBConnection dbConnection = DBConnection.instance();

    public static IManageBookingModel instance() {
        if (null == singleInstance) {
            singleInstance = new ManageBookingModel();
        }
        return singleInstance;
    }

    public List<HashMap<String, Object>> bookings(IRequest bookingRequest) {
        Connection connection = dbConnection.createConnection();
        List<HashMap<String, Object>> results= new ArrayList<>();

        try {

            String getBookingQuery = "SELECT bookingId , userType,firstName, lastName, airlines, airport, " +
                    "flightNumber, price, extraBaggage, seatInformation, insurance, destination, departureDate, " +
                    "returnDate, numberOfPessengers, origin ,flightClass, flightType, pnr " +
                    "FROM `5308_FlightBooking` WHERE pnr = ? and userID = ? ";

            PreparedStatement booking_code_statement = connection.prepareStatement(getBookingQuery);
            booking_code_statement.setString(1, bookingRequest.getPNR());
            booking_code_statement.setInt(2, bookingRequest.getUserId());
            ResultSet booking_code_result =  booking_code_statement.executeQuery();

            while (booking_code_result.next()) {
                HashMap<String, Object> result = new HashMap<String, Object>();

                result.put("bookingId", booking_code_result.getInt("bookingId"));
                result.put("userType", booking_code_result.getInt("userType"));
                result.put("firstName", booking_code_result.getString("firstName"));
                result.put("lastName", booking_code_result.getString("lastName"));
                result.put("airlines", booking_code_result.getString("airlines"));
                result.put("airport", booking_code_result.getString("airport"));
                result.put("flightNumber", booking_code_result.getString("flightNumber"));
                result.put("price", booking_code_result.getInt("price"));
                result.put("extraBaggage", booking_code_result.getInt("extraBaggage"));
                result.put("seatInformation", booking_code_result.getString("seatInformation"));
                result.put("insurance", booking_code_result.getString("insurance"));
                result.put("origin", booking_code_result.getString("origin"));
                result.put("destination", booking_code_result.getString("destination"));
                result.put("departureDate", booking_code_result.getString("departureDate"));
                result.put("returnDate", booking_code_result.getString("returnDate"));
                result.put("numberOfPessengers", booking_code_result.getInt("numberOfPessengers"));
                result.put("flightClass", booking_code_result.getString("flightClass"));
                result.put("flightType", booking_code_result.getString("flightType"));
                result.put("pnr", booking_code_result.getString("pnr"));
                //result.put("userID", booking_code_result.getInt("userID"));

                results.add(result);
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

    @Override
    public boolean editBooking(IRequest editRequest) {
        Connection connection = dbConnection.createConnection();
        boolean result = false;
        try {
            String editBookingQuery = "UPDATE "+ FLIGHT_BOOKING +" set `extraBaggage` = ?, `insurance` = ?, " +
                    "`flightClass` = ?, `numberOfPessengers` = ?, `seatInformation` = ?, `price` = ? where `pnr` = ?";

            int updatedPrice = updatedPrice(editRequest);
            PreparedStatement preparedStatement = connection.prepareStatement(editBookingQuery);
            preparedStatement.setInt(1, editRequest.getExtraBaggage());
            preparedStatement.setString(2, editRequest.getInsurance());
            preparedStatement.setString(3, editRequest.getFlightClass());
            preparedStatement.setInt(4, editRequest.getNumberOfPassengers());
            preparedStatement.setString(5, editRequest.getSeatInformation());
            preparedStatement.setInt(6, updatedPrice);
            preparedStatement.setString(7, editRequest.getPNR());

            int editResult =  preparedStatement.executeUpdate();
            if (editResult==1){
                result = true;
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
        return result;
    }

    @Override
    public boolean deleteBooking(IRequest Request){
        Connection connection = dbConnection.createConnection();
        boolean result = false;
        try {
            String deleteBookingQuery = "DELETE FROM "+ FLIGHT_BOOKING +" WHERE pnr = ? and userID = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteBookingQuery);
            preparedStatement.setString(1, Request.getPNR());
            preparedStatement.setInt(2, Request.getUserId());
            int deleteResult =  preparedStatement.executeUpdate();

            if (deleteResult==1){
                result = true;
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
        return result;
    }

    public int updatedPrice(IRequest price){
        int finalPrice = BASE_PRICE;
        if (price.getFlightClass().equalsIgnoreCase("BUSINESS")){
            finalPrice = finalPrice+BUSINESS_CLASS_CHARGES;
        }
        if (price.getInsurance().equalsIgnoreCase("Y")){
            finalPrice = finalPrice+INSURANCE_PRICE;
        }
        finalPrice = (finalPrice*price.getNumberOfPassengers())+((price.getExtraBaggage()-1)*EXTRA_BAGGAGE_PRICE);
        return finalPrice;
    }
}