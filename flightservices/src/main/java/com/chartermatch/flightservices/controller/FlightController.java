package com.chartermatch.flightservices.controller;

import com.chartermatch.flightservices.service.FlightService;
import com.chartermatch.flightservices.service.FlightServiceImpl;
import com.chartermatch.flightservices.to.FlightTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class FlightController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

    @Autowired
    private FlightService flightService;

    @RequestMapping(path = "/flights", method = RequestMethod.GET)
    public List<FlightTo> getFlights() {
        LOGGER.info("getFlights invoked");
        return flightService.getFlights();
    }
}
