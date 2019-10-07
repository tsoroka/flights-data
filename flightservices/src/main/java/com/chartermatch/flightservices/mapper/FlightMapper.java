package com.chartermatch.flightservices.mapper;

import com.chartermatch.flightservices.to.FlightTo;

import java.time.LocalTime;
import java.util.Arrays;

public class FlightMapper {

    public static FlightTo toFlightTo(String[] flightsData) {
        FlightTo flightTo = new FlightTo();
        flightTo.setDepartureTime(LocalTime.parse(flightsData[0]));
        flightTo.setDestination(flightsData[1]);
        flightTo.setDestinationAirport(flightsData[2]);
        flightTo.setFlightNumber(flightsData[3]);

        String[] dayOfWeeks = Arrays.copyOfRange(flightsData, 4, 11);
        for (String dayOfWeek : dayOfWeeks) {
            if (dayOfWeek != null && "x".equalsIgnoreCase(dayOfWeek.trim())) {
                flightTo.add(1);
            } else {
                flightTo.add(0);
            }
        }
        return flightTo;
    }
}
