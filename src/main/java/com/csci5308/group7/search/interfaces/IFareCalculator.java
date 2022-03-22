package com.csci5308.group7.search.interfaces;
//
import java.util.Map;

public interface IFareCalculator {
    public double multiplyingFactor(int ClassSeats,int ClassCapacity);
    public double dynamicfare(Map<String, Object> result, IRequest searchRequest);
}
