package com.csci5308.group7.search.abstractfactory;

import com.csci5308.group7.search.*;
import com.csci5308.group7.search.interfaces.*;

public class SearchFactory extends AbstractSearchFactory {

    @Override
    public ISearch createSearch() {
        return new Search();
    }

    @Override
    public ISearchModel createSearchModel() {
        return new SearchModel();
    }

    @Override
    public IRequest createRequest() {
        return new Request();
    }

    @Override
    public IResponse createResponse() {
        return new Response();
    }

    @Override
    public IFareCalculator createFareCalculator() {
        return new FareCalculator();
    }
}
