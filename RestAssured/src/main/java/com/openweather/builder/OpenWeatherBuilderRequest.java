package com.openweather.builder;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Raman_Patsiayuk
 */
public class OpenWeatherBuilderRequest {
    private String url;

    public OpenWeatherBuilderRequest() {
        this.url = StringUtils.EMPTY;
    }

    public OpenWeatherBuilderRequest setCityName(String cityName) {
        this.url += new StringBuilder().append("?q=").append(cityName);
        return this;
    }

    public OpenWeatherBuilderRequest setCityId(String id) {
        this.url += new StringBuilder().append("?id=").append(id);
        return this;
    }

    public OpenWeatherBuilderRequest setGeographicCoordinates(String lat, String lon) {
        this.url += new StringBuilder().append("?lat=").append(lat).append("&lon=").append(lon);
        return this;
    }

    public OpenWeatherBuilderRequest setZip(String zipCode) {
        this.url += new StringBuilder().append("?zip=").append(zipCode);
        return this;
    }

    public OpenWeatherBuilderRequest setMode(String mode) {
        this.url += new StringBuilder().append("&mode=").append(mode);
        return this;
    }

    public String build() {
        return this.url + "&APPID=c893442b753870781d1f92e6457cd9a3";
    }
}
