package com.example.demoMetaWeather.service;

import com.example.demoMetaWeather.json.response.CityLocationResponse;
import com.example.demoMetaWeather.json.response.CityResponse;
import com.example.demoMetaWeather.json.response.CityTemperatureResponse;
import com.example.demoMetaWeather.utils.Utils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * service implementation
 * @author Keylis Valles
 * @since 19-06-2020
 * service implementation
 */

@Service
public class CityServiceImpl implements CityService{

    private static final Logger LOG = LoggerFactory.getLogger(CityServiceImpl.class);

    @Value("${urlBase}")
    private String urlBase;

    @Value("${location.search}")
    private String locationSearch;

    @Value("${location}")
    private String woeid;

    public final static String OK = "OK";
    public final static String NOK = "NOK";

    @Override
    public CityTemperatureResponse getCityService(String city){
        String logMessage = "";
        Integer woeid = 0;
        CityResponse cityResponse = new CityResponse();
        CityTemperatureResponse cityTemperatureResponse = new CityTemperatureResponse();
        CityLocationResponse cityLocationResponse = new CityLocationResponse();
        if(city != null && !city.isEmpty()){
            logMessage = "[city->" + city + "]";
            LOG.info("{} Service consumption starts", logMessage);
            try{
                String url = urlBase.concat(locationSearch).concat("?query={q}");
                URI uri = UriComponentsBuilder.fromUriString(url).build(city);
                RequestEntity<Void> requestEntity = RequestEntity.get(uri).header(("query"),city).build();
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                LOG.info("{} Headers are initialized", logMessage);
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<String> entity = new HttpEntity<>(headers);
                LOG.info("Consuming Location Search Service {} ", url);
                ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
                JSONObject jsonObject = new JSONObject(resp); //to create the JSONObject object
                HashMap<String, Object> hashMap = new HashMap<>(Utils.toMap(jsonObject));
                String body = hashMap.get("body").toString();
                cityResponse.setResponseCode(Integer.parseInt(hashMap.get("statusCodeValue").toString()));
                cityResponse.setResponse(hashMap.get("statusCode").toString());
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<CityResponse>>(){}.getType();
                ArrayList<CityResponse> listCity = gson.fromJson(body, listType);
                LOG.info("{} The response object is obtained", logMessage, listCity);
                if(listCity.size() > 0){
                    woeid = listCity.get(0).getWoeid();
                    cityResponse.setTitle(listCity.get(0).getTitle());
                    cityResponse.setLocation_type(listCity.get(0).getLocation_type());
                    cityResponse.setWoeid(woeid);
                    cityResponse.setLatt_long(listCity.get(0).getLatt_long());
                    LOG.info("{} The weoidCity", woeid);
                    List<CityLocationResponse> resultCityLocation = getCityLocationServcice(woeid);
                    LOG.info("{} The Location Service response object is obtained", logMessage, resultCityLocation);
                    CityLocationResponse response = new CityLocationResponse();
                    cityLocationResponse = resultCityLocation.get(resultCityLocation.size() - 1);
                    cityTemperatureResponse.setCityResponse(cityResponse);
                    cityTemperatureResponse.setTemp_Celsius(cityLocationResponse.getThe_temp());
                    cityTemperatureResponse.setTemp_Fahrenheit(Utils.centigradesToFahrenheit(cityLocationResponse.getThe_temp()));
                }
                LOG.info("{} The response object is obtained", logMessage);
            }catch (Exception e) {
                LOG.error("{} getCity: An error of the type has occurred: {}", logMessage, e);
                cityTemperatureResponse.getCityResponse().setResponseCode(e.hashCode());
                cityTemperatureResponse.getCityResponse().setResponse(e.getMessage());
            }
        }else{
            LOG.info("Request null or empty");
        }
        return cityTemperatureResponse;
    }

    @Override
    public  List<CityLocationResponse> getCityLocationServcice(Integer weoidCity){
        String logMessage = "";
        CityLocationResponse cityLocationResponse = new CityLocationResponse();
        List<CityLocationResponse> locationResponses = new ArrayList<>();
        if(weoidCity != null && weoidCity > 0){
            logMessage = "[weoidCity->" + weoidCity + "]";
            LOG.info("{} Service consumption starts", logMessage);
            try{
                String url = urlBase.concat(weoidCity.toString());
                URI uri = UriComponentsBuilder.fromUriString(url).build("");
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                LOG.info("{} Headers are initialized", logMessage);
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<String> entity = new HttpEntity<>(headers);
                LOG.info("Consuming Location Service {} ", url);
                ResponseEntity<String> resp = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
                HashMap<String, Object> hashMap = new HashMap<>(Utils.jsonToMap(resp.getBody()));
                for(Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if(entry.getKey().equalsIgnoreCase("consolidated_weather")){
                        for(int i = 0; i < ((ArrayList) entry.getValue()).size(); i++){
                            CityLocationResponse response = new CityLocationResponse();
                            HashMap weatherResponse = (HashMap) ((ArrayList) entry.getValue()).get(i);
                            response.setId(weatherResponse.get("id").toString());
                            response.setApplicable_date(weatherResponse.get("applicable_date").toString());
                            response.setWeather_state_name(weatherResponse.get("weather_state_name").toString());
                            response.setWeather_state_abbr(weatherResponse.get("weather_state_abbr").toString());
                            response.setWind_speed(Double.parseDouble(weatherResponse.get("wind_speed").toString()));
                            response.setWind_direction(Double.parseDouble(weatherResponse.get("wind_direction").toString()));
                            response.setWind_direction_compass(weatherResponse.get("wind_direction_compass").toString());
                            response.setMin_temp(Double.parseDouble(weatherResponse.get("min_temp").toString()));
                            response.setMax_temp(Double.parseDouble(weatherResponse.get("max_temp").toString()));
                            response.setThe_temp(Double.parseDouble(weatherResponse.get("the_temp").toString()));
                            response.setAir_pressure(Double.parseDouble(weatherResponse.get("air_pressure").toString()));
                            response.setHumidity(Double.parseDouble(weatherResponse.get("humidity").toString()));
                            response.setVisibility(Double.parseDouble(weatherResponse.get("visibility").toString()));
                            response.setPredictability(Double.parseDouble(weatherResponse.get("predictability").toString()));
                            response.setCreated(weatherResponse.get("created").toString());
                            locationResponses.add(response);
                        }
                    }
                }
                LOG.info("{} The response object is obtained", logMessage, locationResponses);
            }catch (Exception e) {
                LOG.error("{} getCity: An error of the type has occurred: {}", logMessage, e);
                cityLocationResponse.setResponseCode(e.hashCode());
                cityLocationResponse.setResponse(e.getMessage());
            }
        }else{
            LOG.info("weoidCity null or invalid number");
        }
        return  locationResponses;
    }
}
