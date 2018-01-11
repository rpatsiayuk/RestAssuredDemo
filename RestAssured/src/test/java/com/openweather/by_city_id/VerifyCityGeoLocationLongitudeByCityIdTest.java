package com.openweather.by_city_id;

import com.openweather.BaseTest;
import com.openweather.builder.OpenWeatherBuilderRequest;
import io.qameta.allure.Feature;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.config.JsonConfig.jsonConfig;
import static io.restassured.path.json.config.JsonPathConfig.NumberReturnType.BIG_DECIMAL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


/**
 * Created by Raman_Patsiayuk
 */
@Feature("City geo location tests by city Id")
public class VerifyCityGeoLocationLongitudeByCityIdTest extends BaseTest {
    //static final Logger LOGGER = Logger.getLogger(OpenWeatherTest.class);

    @Test
    public void verifyCityGeoLocationLongitudeTest() {
        String request = new OpenWeatherBuilderRequest().setCityId("629634").build();
        float expectedResult = Float.parseFloat("23.7");
        Response response = get(request);
        assertThat(response.getStatusCode(), is(equalTo(200))); //проверили, что сервис возвращает на статус 200 ОК
        String json = response.asString(); // преобразовали наш response в строку
        JsonPath jsonPath = new JsonPath(json);
        float actualResult = jsonPath.get("coord.lon");//получили значение элемента coord.lon
        assertThat(actualResult, equalTo(expectedResult)); // сравнили значение возвращаемое с сервиса, со значением, которое мы ожидаем
    }

    @Test
    public void verifyCityGeoLocationLongitudeCucumberTest() {
        String request = new OpenWeatherBuilderRequest().setCityId("629634").build();
        given()
                //.config(RestAssuredConfig.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL)))
                .log()
                .all()
                .when()
                .get(request)
                .then()
                .assertThat()
                //.body("coord.lon", is(new BigDecimal(23.7)));
                .body("coord.lon", is(23.7F));
    }
}
