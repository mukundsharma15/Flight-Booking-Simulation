package com.csci5308.group7.search;

import com.csci5308.group7.search.interfaces.IResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Response implements IResponse {
    public Boolean success;
    public List<HashMap <String, Object>> results;

    public Response() {
        this.success = false;
        this.results = new ArrayList<HashMap<String, Object>>();
    }

    public Response(Boolean success) {
        this.success = success;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setResults(List<HashMap <String, Object>> searchResults) {
        this.results = searchResults;
    }

    public List<HashMap <String, Object>> getResults() {
        return results;
    }

    public void addResult(HashMap <String, Object> searchResult) {
        this.results.add(searchResult);
    }

    @Override
    public String getFailureMessage(String message) {
        return "{  \"success\" : false, \"message\": " + message + " }";
    }

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
    public void appendResults(List<HashMap <String, Object>> results) {
        this.results.addAll(results);
    }
}
