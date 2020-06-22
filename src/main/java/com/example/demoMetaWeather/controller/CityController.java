package com.example.demoMetaWeather.controller;


import com.example.demoMetaWeather.json.response.CityTemperatureResponse;
import com.example.demoMetaWeather.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * URI: http://localhost:8080/getCity/{city}
 * @author Keylis Valles
 * @since 19-06-2020
 * service controller class
 */
@RestController
public class CityController {

    private static final Logger LOG = LoggerFactory.getLogger(CityController.class);

    @Autowired
    CityService cityService;

    /**
     * service that indicates the Celsius and Fahrenheit temperatures of a city
     * @param city
     * @return CityResponse,
     */
    @GetMapping("/getCity/{city}")
    public CityTemperatureResponse getCity(@PathVariable String city) {
        LOG.info("The process to obtain information about the city begins");
        CityTemperatureResponse response = cityService.getCityService(city);
        LOG.info("The process to obtain information about the city is finished");
        return response;
    }



}
