package com.example.demoMetaWeather.service;

import com.example.demoMetaWeather.json.response.CityLocationResponse;
import com.example.demoMetaWeather.json.response.CityTemperatureResponse;

import java.util.List;

/**
 * service interface
 * @author Keylis Valles
 * @since 19-06-2020
 * service interface
 */
public interface CityService {

    CityTemperatureResponse getCityService(String city);

    List<CityLocationResponse> getCityLocationServcice(Integer weoidCity);


}
