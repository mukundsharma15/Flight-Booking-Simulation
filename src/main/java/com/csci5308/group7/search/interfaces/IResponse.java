package com.csci5308.group7.search.interfaces;

import java.util.HashMap;
import java.util.List;

public interface IResponse {
    public Boolean getSuccess();

    public void setSuccess(Boolean success);

    public String toString();

    public void appendResults(List<HashMap <String, Object>> results);

    public void setResults(List<HashMap<String, Object>> searchResults);

    public List<HashMap <String, Object>> getResults();

    public void addResult(HashMap <String, Object> searchResult);

    public String getFailureMessage(String message);
}
