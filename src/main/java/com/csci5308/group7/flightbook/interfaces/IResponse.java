package com.csci5308.group7.flightbook.interfaces;


import java.util.HashMap;

public interface IResponse {

    public Boolean getSuccess();

    public void setSuccess(Boolean success);

    public HashMap<String, Object> getResult();

    public void setResult(HashMap<String, Object> result);

    public String toString();

    public String getFailureMessage(String message);
}
