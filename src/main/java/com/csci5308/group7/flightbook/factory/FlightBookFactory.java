package com.csci5308.group7.flightbook.factory;

import com.csci5308.group7.flightbook.*;
import com.csci5308.group7.flightbook.interfaces.IBook;
import com.csci5308.group7.flightbook.interfaces.IDetailsModel;
import com.csci5308.group7.flightbook.interfaces.IRequest;
import com.csci5308.group7.flightbook.interfaces.IResponse;


public class FlightBookFactory extends AbstractFlightBookFactory {

    @Override
    public IBook createFlightBook() {
        return new Book();
    }

    @Override
    public IDetailsModel createFlightBookModel() {
        return new DetailsModel();
    }

    @Override
    public IRequest createRequest() {
        return new Request();
    }

    @Override
    public IResponse createResponse() {
        return new Response();
    }
}
