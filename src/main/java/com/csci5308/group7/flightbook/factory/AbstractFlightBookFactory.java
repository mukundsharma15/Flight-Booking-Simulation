package com.csci5308.group7.flightbook.factory;

import com.csci5308.group7.flightbook.interfaces.IBook;
import com.csci5308.group7.flightbook.interfaces.IDetailsModel;
import com.csci5308.group7.flightbook.interfaces.IRequest;
import com.csci5308.group7.flightbook.interfaces.IResponse;

public abstract class AbstractFlightBookFactory {
    private static AbstractFlightBookFactory instance = null;

    protected AbstractFlightBookFactory() {
    }

    public static AbstractFlightBookFactory instance() {
        if (instance == null) {
            instance = new FlightBookFactory();
        }
        return instance;
    }

    public abstract IBook createFlightBook();
    public abstract IDetailsModel createFlightBookModel();
    public abstract IRequest createRequest();
    public abstract IResponse createResponse();

}
