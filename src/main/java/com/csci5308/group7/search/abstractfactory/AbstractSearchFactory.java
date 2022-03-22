package com.csci5308.group7.search.abstractfactory;

import com.csci5308.group7.search.interfaces.*;

public abstract class AbstractSearchFactory {
    private static AbstractSearchFactory instance = null;

    protected AbstractSearchFactory() {
    }

    public static AbstractSearchFactory instance() {
        if (instance == null) {
            instance = new SearchFactory();
        }
        return instance;
    }

    public abstract ISearch createSearch();
    public abstract ISearchModel createSearchModel();
    public abstract IRequest createRequest();
    public abstract IResponse createResponse();
    public abstract IFareCalculator createFareCalculator();
}
