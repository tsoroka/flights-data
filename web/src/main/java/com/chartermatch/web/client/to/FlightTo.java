package com.chartermatch.web.client.to;

import lombok.Data;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FlightTo {

    private LocalTime departureTime;

    private String destination;

    private String destinationAirport;

    private String flightNumber;

    private boolean departured;

    private List<Integer> daysOfWeek = new ArrayList<>(7);

}
