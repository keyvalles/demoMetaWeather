package com.example.demoMetaWeather.json.response;

/**
 * CityResponse, object response of the Location service
 * @author Keylis Valles
 * @since 19-06-2020
 * service controller class
 */
public class CityLocationResponse extends CityResponse
        implements Comparable<CityLocationResponse> {

    String id;
    String applicable_date;
    String weather_state_name;
    String weather_state_abbr;
    Double wind_speed;
    Double wind_direction;
    String wind_direction_compass;
    Double min_temp;
    Double max_temp;
    Double the_temp;
    Double air_pressure;
    Double humidity;
    Double visibility;
    Double predictability;
    String created;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(Double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public Double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(Double min_temp) {
        this.min_temp = min_temp;
    }

    public Double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(Double max_temp) {
        this.max_temp = max_temp;
    }

    public Double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(Double the_temp) {
        this.the_temp = the_temp;
    }

    public Double getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(Double air_pressure) {
        this.air_pressure = air_pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getVisibility() {
        return visibility;
    }

    public void setVisibility(Double visibility) {
        this.visibility = visibility;
    }

    public Double getPredictability() {
        return predictability;
    }

    public void setPredictability(Double predictability) {
        this.predictability = predictability;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override public String toString() {
        return "CityLocationResponse{" +
                "id='" + id + '\'' +
                ", applicable_date='" + applicable_date + '\'' +
                ", weather_state_name='" + weather_state_name + '\'' +
                ", weather_state_abbr='" + weather_state_abbr + '\'' +
                ", wind_speed=" + wind_speed +
                ", wind_direction=" + wind_direction +
                ", wind_direction_compass='" + wind_direction_compass + '\'' +
                ", min_temp=" + min_temp +
                ", max_temp=" + max_temp +
                ", the_temp=" + the_temp +
                ", air_pressure=" + air_pressure +
                ", humidity=" + humidity +
                ", visibility=" + visibility +
                ", predictability=" + predictability +
                ", created='" + created + '\'' +
                ", title='" + title + '\'' +
                ", location_type='" + location_type + '\'' +
                ", woeid=" + woeid +
                ", latt_long='" + latt_long + '\'' +
                '}';
    }

    @Override public int compareTo(CityLocationResponse o) {
        return 0;
    }
}
