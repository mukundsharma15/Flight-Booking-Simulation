package com.csci5308.group7.search.factory;

import com.csci5308.group7.search.interfaces.*;
import com.csci5308.group7.search.*;
import com.csci5308.group7.search.model.SearchModelMock;

public class SearchFactoryMock extends AbstractSearchFactoryMock{

    @Override
    public ISearch createSearch() {
        return new Search();
    }

    @Override
    public ISearchModel createSearchModel() {
        return new SearchModelMock();
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
