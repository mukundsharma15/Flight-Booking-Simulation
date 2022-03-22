package com.csci5308.group7.search;

import com.csci5308.group7.search.abstractfactory.AbstractSearchFactory;
import com.csci5308.group7.search.interfaces.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@ResponseBody
@RestController
@RequestMapping("/search")
public class SearchController {

    AbstractSearchFactory searchFactory = AbstractSearchFactory.instance();
    ISearch iSearch = searchFactory.createSearch();
    ISearchModel iSearchModel = searchFactory.createSearchModel();
    IRequest iRequest = searchFactory.createRequest();
    IResponse iResponse = searchFactory.createResponse();

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String search(@RequestBody String searchRequest, @RequestHeader Map<String, String> headers) {
        try {
            JSONObject requestBody = new JSONObject(searchRequest);
            int userId = Integer.parseInt(headers.get("userid"));

            iRequest.setCallingUserId(userId);
            iRequest.setOrigin(requestBody.getString("origin"));
            iRequest.setDestination(requestBody.getString("destination"));
            iRequest.setDepartureDate(requestBody.getString("departureDate"));
            iRequest.setReturnDate(requestBody.getString("returnDate"));
            iRequest.setNumberOfPassengers(requestBody.getInt("numberOfPassengers"));
            iRequest.setFlightClass(FlightClass.valueOf(requestBody.getString("flightClass")));
            iRequest.setFlightType(FlightType.valueOf(requestBody.getString("flightType")));

            iSearch.searchFlight(iRequest, iSearchModel, iResponse);

            return iResponse.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return iResponse.getFailureMessage("Something went wrong");
        }

    }
}
