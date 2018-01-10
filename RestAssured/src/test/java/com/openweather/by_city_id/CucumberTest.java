package com.openweather.by_city_id;

import com.openweather.BaseTest;
import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


/**
 * Created by Raman_Patsiayuk
 */
public class CucumberTest extends BaseTest {

    @Test
    public void verifyCityGeoLocationLongitudeTest() {
                    /* expect()
                     .log()
                     .all()
                    .statusCode(200)
                    .body("id", equalTo(629634))
                    .when()
                    .get("http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3");*/


        given().log()
                .all()
                .filter(new AllureRestAssured())
                .contentType("application/json")
                .when()
                .get("http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body("coord.lon", equalTo(23.69F), "coord.lat", equalTo(52.09F));



       /* Response res = when().get("http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3");
        JsonPath jp = new JsonPath(res.asString());
        Float account = jp.getFloat("coord.lon");*/
    }


}
