package com.example.demoMetaWeather.entity;

import java.io.Serializable;

/**
 * StatusResponse, object response of the service status
 * @author Keylis Valles
 * @since 19-06-2020
 * service controller class
 */
public class StatusResponse implements Serializable {

    private String response;
    private Integer responseCode;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    @Override public String toString() {
        return "Respuesta{" +
                "response='" + response + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }
}
