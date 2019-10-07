package com.chartermatch.flightservices.service;

import com.chartermatch.flightservices.mapper.FlightMapper;
import com.chartermatch.flightservices.to.FlightTo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class FlightServiceImpl implements FlightService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

    @Value("${flightservices.datafile}")
    private String flightsDataFile;

    @Override
    public List<FlightTo> getFlights() {
        List<FlightTo> result = new ArrayList<>();

        Resource classPathResource = new FileSystemResource(flightsDataFile);
        try (BufferedReader br = new BufferedReader(new FileReader(classPathResource.getFile()))) {
            br.readLine();
            String line;
            while (StringUtils.isNotBlank(line = br.readLine())) {
                String[] flightsData = line.split(",");

                FlightTo flightTo = FlightMapper.toFlightTo(flightsData);
                result.add(flightTo);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
        result = result.stream()
                .sorted(Comparator.comparing(FlightTo::getDepartureTime))
                .collect(Collectors.toList());
        return result;
    }
}
