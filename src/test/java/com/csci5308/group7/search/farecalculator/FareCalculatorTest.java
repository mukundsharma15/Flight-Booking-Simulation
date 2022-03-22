package com.csci5308.group7.search.farecalculator;

import com.csci5308.group7.search.FareCalculator;
import com.csci5308.group7.search.factory.AbstractSearchFactoryMock;
import com.csci5308.group7.search.interfaces.IRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class FareCalculatorTest {
    AbstractSearchFactoryMock searchFactory = null;
    IRequest request = null;
    FareCalculator fareCalculator = new FareCalculator();
    Map<String, Object> result;


    @BeforeEach
    void setUp() {
        searchFactory = AbstractSearchFactoryMock.instance();
        request = searchFactory.createRequest();
        result = new HashMap<String, Object>();
    }

    @Test
    void multiplyingFactor() {
        result.put("flightCapacity", 30);
        result.put("economyClass", 90);
        result.put("businessClass", 90);
        result.put("firstClass", 90);
        Assertions.assertEquals(38250,fareCalculator.dynamicfare(result,request));
    }

    @Test
    void dynamicfare() {
        Assertions.assertEquals(1.3,fareCalculator.multiplyingFactor(30,90));
    }
}