package com.csci5308.group7.flightbook;

import com.csci5308.group7.database.DBConnection;
import com.csci5308.group7.database.IDBConnection;
import com.csci5308.group7.flightbook.interfaces.IDetailsModel;
import com.csci5308.group7.flightbook.interfaces.IRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class DetailsModel implements IDetailsModel {

    //Constants
    public static final String FLIGHT_BOOKING = "5308_FlightBooking";
    public static final int PNR_LENGTH = 8;
    public static final String ALLOWED_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final float EXTRA_BAGGAGE_PRICE = 10;
    public static final float INSURANCE_PRICE = 8;
    public static final int ACTIVE_STATUS = 1;

    public static DetailsModel singleInstance = null;
    IDBConnection dbConnection = DBConnection.instance();

    public static IDetailsModel instance() {
        if (null == singleInstance) {
            singleInstance = new DetailsModel();
        }
        return singleInstance;
    }

    public HashMap<String, Object> saveData(IRequest request){
        Connection connection = dbConnection.createConnection();
        String generatedPNR;
        int bookingId;
        float updatedPrice = 0;
        HashMap<String, Object> bookResult = new HashMap<>();

        try{
            String insertUserQuery = "INSERT INTO "+ FLIGHT_BOOKING +"(bookingId, userID, userType, firstName, lastName, " +
                    "airlines, airport, flightNumber, price,  extraBaggage, validPhotoId, seatInformation, insurance, " +
                    "origin, destination, departureDate, returnDate, numberOfPessengers, flightClass, flightType, " +
                    "pnr, activeStatus) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);

            bookingId = generateBookingId();
            updatedPrice = updatePrice(request);
            generatedPNR = generatePNR(ALLOWED_CHAR, PNR_LENGTH);
            preparedStatement.setInt(1, bookingId);
            preparedStatement.setInt(2, request.getUserId());
            preparedStatement.setInt(3, request.getUserType());
            preparedStatement.setString(4, request.getFirstName());
            preparedStatement.setString(5, request.getLastName());
            preparedStatement.setString(6, request.getAirlines());
            preparedStatement.setString(7, request.getAirport());
            preparedStatement.setString(8, request.getFlightNumber());
            preparedStatement.setFloat(9, updatedPrice);
            preparedStatement.setInt(10, request.getExtraBaggage());
            preparedStatement.setString(11, request.getValidProofID());
            preparedStatement.setInt(12, request.getSeatInformation());
            preparedStatement.setString(13, request.getInsurance());
            preparedStatement.setString(14, request.getOrigin());
            preparedStatement.setString(15, request.getDestination());
            preparedStatement.setString(16, request.getDepartureDate());
            preparedStatement.setString(17, request.getReturnDate());
            preparedStatement.setInt(18, request.getNumberOfPassengers());
            preparedStatement.setString(19, request.getFlightClass());
            preparedStatement.setString(20, request.getFlightType());
            preparedStatement.setString(21, generatedPNR);
            preparedStatement.setInt(22, ACTIVE_STATUS);
            preparedStatement.execute();

            //Result

            bookResult.put("bookingId", bookingId);
            bookResult.put("userId", request.getUserId());
            bookResult.put("userType", request.getUserType());
            bookResult.put("firstName", request.getFirstName());
            bookResult.put("lastName", request.getLastName());
            bookResult.put("airlines", request.getAirlines());
            bookResult.put("airport", request.getAirport());
            bookResult.put("flightNumber", request.getFlightNumber());
            bookResult.put("price", updatedPrice);
            bookResult.put("extraBaggage", request.getExtraBaggage());
            bookResult.put("validProofID", request.getValidProofID());
            bookResult.put("seatInformation", request.getSeatInformation());
            bookResult.put("insurance", request.getInsurance());
            bookResult.put("origin", request.getOrigin());
            bookResult.put("destination", request.getDestination());
            bookResult.put("departureDate", request.getDepartureDate());
            bookResult.put("returnDate", request.getReturnDate());
            bookResult.put("numberOfPassengers", request.getNumberOfPassengers());
            bookResult.put("flightClass", request.getFlightClass());
            bookResult.put("flightType", request.getFlightType());
            bookResult.put("pnr", generatedPNR);
            bookResult.put("activeStatus", ACTIVE_STATUS);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return bookResult;
    }

    public static String generatePNR(String chars, int length){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<length;i++){
            stringBuilder.append(chars.charAt(random.nextInt(chars.length())));
        }
        return stringBuilder.toString();
    }

    public float updatePrice(IRequest request){
        float updatedPrice = request.getPrice();
        if (request.getExtraBaggage()>0){
            updatedPrice += request.getExtraBaggage()*EXTRA_BAGGAGE_PRICE;
        }
        if (Objects.equals(request.getInsurance(), "YES")){
            updatedPrice += INSURANCE_PRICE;
        }
        return updatedPrice;
    }

    public static int generateBookingId(){
        return (int) System.currentTimeMillis();
    }

}
