package com.chartermatch.web.controller;

import com.chartermatch.web.client.FlightServicesClient;
import com.chartermatch.web.client.to.FlightTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private FlightServicesClient flightServicesClient;

    @GetMapping("/flights")
    public String getFlights(Model model) {
        List<FlightTo> flights = flightServicesClient.getFlights();
        for (FlightTo flight : flights) {
            flight.setDepartured(flight.getDepartureTime().isAfter(LocalTime.now()));
        }
        model.addAttribute("flights", flights);
        return "index";
    }
}
