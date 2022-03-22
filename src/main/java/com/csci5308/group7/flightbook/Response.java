package com.csci5308.group7.flightbook;

import com.csci5308.group7.flightbook.interfaces.IResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;


public class Response implements IResponse {
    public Boolean success;
    public HashMap<String, Object> result;

    public Response() {
        this.success = false;
    }

    public Response(Boolean success, HashMap<String, Object> result) {
        this.success = success;
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setResult(HashMap<String, Object> result) {
        this.result = result;
    }

    public HashMap<String, Object> getResult() {return result;};


    @Override
    public String toString() {
        String responseData = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            responseData = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return responseData;
    }

    @Override
    public String getFailureMessage(String message) {
        return "{  \"success\" : false, \"message\": " + message + " }";
    }

}
