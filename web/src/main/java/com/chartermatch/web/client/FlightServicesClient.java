package com.chartermatch.web.client;

import com.chartermatch.web.client.to.FlightTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "flight-services")
public interface FlightServicesClient {

    @RequestMapping(method = RequestMethod.GET, value = "/flightservices/flights", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<FlightTo> getFlights();
}
