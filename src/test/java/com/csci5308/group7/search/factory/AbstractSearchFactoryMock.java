package com.csci5308.group7.search.factory;

import com.csci5308.group7.search.interfaces.*;

public abstract class AbstractSearchFactoryMock {

    private static AbstractSearchFactoryMock singleInstance = null;

    protected AbstractSearchFactoryMock() {
    }

    public static AbstractSearchFactoryMock instance (){
        if(singleInstance == null){
            return new SearchFactoryMock();
        }else {
            return singleInstance;
        }
    }

    public abstract ISearch createSearch();
    public abstract ISearchModel createSearchModel();
    public abstract IRequest createRequest();
    public abstract IResponse createResponse();
}
