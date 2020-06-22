package com.example.demoMetaWeather.json.request;

/**
 *
 * @author Keylis Valles
 * @since 19-06-2020
 * request. input data for service consumption
 */
public class CityRequest {

    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override public String toString() {
        return "CityRequest{" +
                "city='" + city + '\'' +
                '}';
    }
}
