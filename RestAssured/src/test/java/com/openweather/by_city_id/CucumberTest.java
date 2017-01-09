package com.openweather.by_city_id;

import com.openweather.BaseTest;
import com.openweather.builder.OpenWeatherBuilderRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


/**
 * Created by Raman_Patsiayuk
 */
public class CucumberTest extends BaseTest {

    @Test
    public void verifyCityGeoLocationLongitudeTest() {
                    /* expect()
                    .statusCode(200)
                    .body("id", equalTo("629634"))
                    .when()
                    .get("http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3");*/

       /* given().contentType("application/json").
                when().
                get("http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3").
                then().
                statusCode(200)
                .and()
                .assertThat()
                .body("coord.lon", equalTo(23.7), "coord.lat", equalTo(52.0));*/
    }
}
