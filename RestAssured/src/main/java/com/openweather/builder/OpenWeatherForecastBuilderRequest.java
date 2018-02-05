package com.openweather.builder;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Raman_Patsiayuk
 */
public class OpenWeatherForecastBuilderRequest {
    private String url;
    private static final String APP_ID="c893442b753870781d1f92e6457cd9a3";

    public OpenWeatherForecastBuilderRequest() {
        this.url = StringUtils.EMPTY;
    }

    public OpenWeatherForecastBuilderRequest setCityName(String cityName) {
        this.url += new StringBuilder().append("forecast").append("?q=").append(cityName);
        return this;
    }

    public OpenWeatherForecastBuilderRequest setCityId(String id) {
        this.url += new StringBuilder().append("forecast").append("?id=").append(id);
        return this;
    }

    public OpenWeatherForecastBuilderRequest setGeographicCoordinates(String lat, String lon) {
        this.url += new StringBuilder().append("forecast").append("?lat=").append(lat).append("&lon=").append(lon);
        return this;
    }

    public OpenWeatherForecastBuilderRequest setZip(String zipCode) {
        this.url += new StringBuilder().append("forecast").append("?zip=").append(zipCode);
        return this;
    }

    public OpenWeatherForecastBuilderRequest setMode(String mode) {
        this.url += new StringBuilder().append("forecast").append("&mode=").append(mode);
        return this;
    }

    public String build() {
        return this.url + String.format("&APPID=%s",APP_ID);
    }
}
