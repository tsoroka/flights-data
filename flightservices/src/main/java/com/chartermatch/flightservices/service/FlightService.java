package com.chartermatch.flightservices.service;

import com.chartermatch.flightservices.to.FlightTo;

import java.util.List;

public interface FlightService {

    public List<FlightTo> getFlights();
}
