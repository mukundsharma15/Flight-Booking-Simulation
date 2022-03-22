package com.csci5308.group7.bookings;

import com.csci5308.group7.bookings.factory.AbstractBookingFactory;
import com.csci5308.group7.bookings.interfaces.IBooking;
import com.csci5308.group7.bookings.interfaces.IManageBookingModel;
import com.csci5308.group7.bookings.interfaces.IRequest;
import com.csci5308.group7.bookings.interfaces.IResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@ResponseBody
@RestController
@RequestMapping("/manageBooking")
public class ManageBookingController {

    AbstractBookingFactory bookingFactory = AbstractBookingFactory.instance();
    IBooking iBooking = bookingFactory.getBooking();
    IManageBookingModel iBookingModel = bookingFactory.createBookingModel();
    IRequest iRequest = bookingFactory.createRequest();
    IResponse iResponse = bookingFactory.createResponse();

    @PostMapping(value = "/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    public String bookings(@RequestBody String bookingRequest, @RequestHeader Map<String, String> headers) {
        try {
            int userId = Integer.parseInt(headers.get("userid"));
            JSONObject requestBody = new JSONObject(bookingRequest);
            iRequest.setPNR(requestBody.getString("pnr"));
            iRequest.setUserId(userId);
            iBooking.getBookings(iRequest, iBookingModel, iResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return iResponse.toString();
    }

    @PostMapping(value = "/booking/edit", produces = MediaType.APPLICATION_JSON_VALUE)
    public String editBooking(@RequestBody String request) {

        try {
            JSONObject requestBody = new JSONObject(request);

            iRequest.setPNR(requestBody.getString("pnr"));
            iRequest.setExtraBaggage(requestBody.getInt("extraBaggage"));
            iRequest.setInsurance(requestBody.getString("insurance"));
            iRequest.setFlightClass(requestBody.getString("flightClass"));
            iRequest.setNumberOfPassengers(requestBody.getInt("numberOfPassengers"));
            iRequest.setSeatInformation(requestBody.getString("seatInformation"));
            iRequest.setPrice(requestBody.getInt("price"));

            iBooking.editBooking(iRequest, iBookingModel, iResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return iResponse.toString();
    }

    @PostMapping(value = "/booking/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteBooking(@RequestBody String request, @RequestHeader Map<String, String> headers) {

        try {
            int userId = Integer.parseInt(headers.get("userid"));
            JSONObject requestBody = new JSONObject(request);
            iRequest.setPNR(requestBody.getString("pnr"));
            iRequest.setUserId(userId);
            iBooking.deleteBooking(iRequest, iBookingModel, iResponse);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return iResponse.toString();
    }

}
