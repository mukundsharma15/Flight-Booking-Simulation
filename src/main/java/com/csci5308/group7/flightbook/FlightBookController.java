package com.csci5308.group7.flightbook;

import com.csci5308.group7.flightbook.factory.AbstractFlightBookFactory;
import com.csci5308.group7.flightbook.interfaces.IBook;
import com.csci5308.group7.flightbook.interfaces.IDetailsModel;
import com.csci5308.group7.flightbook.interfaces.IRequest;
import com.csci5308.group7.flightbook.interfaces.IResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@ResponseBody
@RestController
@RequestMapping("/flightbook")
public class FlightBookController {
    AbstractFlightBookFactory flightBookFactory = AbstractFlightBookFactory.instance();
    IRequest iRequest = flightBookFactory.createRequest();
    IBook iBook = flightBookFactory.createFlightBook();
    IDetailsModel iDetailsModel = flightBookFactory.createFlightBookModel();
    IResponse iResponse = flightBookFactory.createResponse();

    @RequestMapping(value = "/booking", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String book(@RequestBody String searchRequest, @RequestHeader Map<String, String> headers) {
        try {
            JSONObject requestBody = new JSONObject(searchRequest);
            int userId = Integer.parseInt(headers.get("userid"));

            iRequest.setUserId(userId);
            iRequest.setUserType(requestBody.getInt("userType"));
            iRequest.setFirstName(requestBody.getString("firstName"));
            iRequest.setLastName(requestBody.getString("lastName"));
            iRequest.setAirlines(requestBody.getString("airlines"));
            iRequest.setAirport(requestBody.getString("airport"));
            iRequest.setFlightNumber(requestBody.getString("flightNumber"));
            iRequest.setPrice(requestBody.getInt("price"));
            iRequest.setExtraBaggage(requestBody.getInt("extraBaggage"));
            iRequest.setValidProofID(requestBody.getString("validProofID"));
            iRequest.setSeatInformation(requestBody.getInt("seatInformation"));
            iRequest.setInsurance(requestBody.getString("insurance"));
            iRequest.setOrigin(requestBody.getString("origin"));
            iRequest.setDestination(requestBody.getString("destination"));
            iRequest.setDepartureDate(requestBody.getString("departureDate"));
            iRequest.setReturnDate(requestBody.getString("returnDate"));
            iRequest.setNumberOfPassengers(requestBody.getInt("numberOfPassengers"));
            iRequest.setFlightClass(requestBody.getString("flightClass"));
            iRequest.setFlightType(requestBody.getString("flightType"));

            iBook.bookFlight(iRequest, iDetailsModel, iResponse);
            return iResponse.toString();

        } catch (JSONException e) {
            e.printStackTrace();
            return iResponse.getFailureMessage("Something went wrong");
        }
    }

}
