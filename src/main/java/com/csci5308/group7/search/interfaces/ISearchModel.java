package com.csci5308.group7.search.interfaces;

import java.util.HashMap;
import java.util.List;

public interface ISearchModel {
    public List<HashMap<String, Object>> getFlights(IRequest searchRequest);
}
