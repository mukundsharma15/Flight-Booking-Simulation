package com.csci5308.group7.flightbook;


import com.csci5308.group7.flightbook.interfaces.IBook;
import com.csci5308.group7.flightbook.interfaces.IRequest;
import com.csci5308.group7.flightbook.interfaces.IDetailsModel;
import com.csci5308.group7.flightbook.interfaces.IResponse;

import java.util.HashMap;

public class Book implements IBook {
    @Override
    public void bookFlight(IRequest request, IDetailsModel detailsModel, IResponse response){
        HashMap<String, Object> result = detailsModel.saveData(request);
//        detailsModel.getDetails(request);
        response.setSuccess(Boolean.TRUE);
        response.setResult(result);
    }
}
