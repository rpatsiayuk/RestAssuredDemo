package com.openweather.forecast.by_city_id;

import com.openweather.BaseTest;
import com.openweather.builder.OpenWeatherBuilderRequest;
import com.openweather.builder.OpenWeatherForecastBuilderRequest;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

public class ForecastByCityId extends BaseTest {
    String request = new OpenWeatherForecastBuilderRequest()
            .setCityId("629634")
            .build();

    @Test
    public void openWeatherForecastByCityIdTest() {
        getFilter()
        .when()
                .get(request)
                .then()
                .log()
                .all()
                .assertThat()
                .body("message", is(0.0066F));
    }

    @Test
    public void openWeatherForecastByCityIdUsingParamsTest() {
        getFilter()
                .params("id","629634","APPID","c893442b753870781d1f92e6457cd9a3")
                .when()
                .get()
                .then()
                .log()
                .all()
                .assertThat()
                .body("message", is(0.0066F));
    }
}
