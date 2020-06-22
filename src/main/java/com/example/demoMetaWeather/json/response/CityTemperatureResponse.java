package com.example.demoMetaWeather.json.response;

import java.io.Serializable;


/**
 * CityResponse, object response of the demoMetaWeather service
 * @author Keylis Valles
 * @since 19-06-2020
 * service controller class
 */
public class CityTemperatureResponse implements Serializable {

    Double temp_Fahrenheit;
    Double temp_Celsius;
    CityResponse cityResponse;


    public Double getTemp_Fahrenheit() {
        return temp_Fahrenheit;
    }

    public void setTemp_Fahrenheit(Double temp_Fahrenheit) {
        this.temp_Fahrenheit = temp_Fahrenheit;
    }

    public Double getTemp_Celsius() {
        return temp_Celsius;
    }

    public void setTemp_Celsius(Double temp_Celsius) {
        this.temp_Celsius = temp_Celsius;
    }

    public CityResponse getCityResponse() {
        return cityResponse;
    }

    public void setCityResponse(CityResponse cityResponse) {
        this.cityResponse = cityResponse;
    }

    @Override public String toString() {
        return "CityTemperatureResponse{" +
                "temp_Fahrenheit=" + temp_Fahrenheit +
                ", temp_Celsius=" + temp_Celsius +
                ", cityResponse=" + cityResponse +
                '}';
    }
}
