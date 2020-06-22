package com.example.demoMetaWeather.json.response;

import com.example.demoMetaWeather.entity.StatusResponse;

import java.io.Serializable;


/**
 * CityResponse, object response of the Location Search service
 * @author Keylis Valles
 * @since 19-06-2020
 * service controller class
 */
public class CityResponse extends StatusResponse implements Serializable {

    String title;
    String location_type;
    Integer woeid;
    String latt_long;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public Integer getWoeid() {
        return woeid;
    }

    public void setWoeid(Integer woeid) {
        this.woeid = woeid;
    }

    public String getLatt_long() {
        return latt_long;
    }

    public void setLatt_long(String latt_long) {
        this.latt_long = latt_long;
    }

    @Override public String toString() {
        return "CityResponse{" +
                "title='" + title + '\'' +
                ", location_type='" + location_type + '\'' +
                ", woeid=" + woeid +
                ", latt_long='" + latt_long + '\'' +
                '}';
    }
}
