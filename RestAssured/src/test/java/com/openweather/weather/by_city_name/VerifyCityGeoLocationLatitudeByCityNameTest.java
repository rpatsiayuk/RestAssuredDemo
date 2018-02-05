package com.openweather.weather.by_city_name;

import com.openweather.BaseTest;
import com.openweather.builder.OpenWeatherBuilderRequest;
import io.qameta.allure.Feature;
import org.junit.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.matchers.JUnitMatchers.hasItem;


/**
 * Created by Raman_Patsiayuk
 */
@Feature("City geo location tests by city name")
public class VerifyCityGeoLocationLatitudeByCityNameTest extends BaseTest {
    //http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3
    static final Logger LOGGER = LogManager.getLogger(VerifyCityGeoLocationLatitudeByCityNameTest.class);

    @Test
    public void verifyCityGeoLocationLatitudeTest() {
        String request = new OpenWeatherBuilderRequest()
                .setCityName("Brest,by")
                .build();

        String response = get(request).asString();
        LOGGER.info(response);
        // Get the sum of all author length's as an int. "from" is again statically imported from the JsonPath class
        List<String> weatherId = from(response).getList("weather.id");
        assertThat(weatherId, hasItem("804"));

        /*float expectedResult = Float.parseFloat("52.09");
        Response response = get(request);
        LOGGER.info(response.asString());
        assertThat(response.getStatusCode(), is(equalTo(200))); //проверили, что сервис возвращает на статус 200 ОК
        String json = response.asString(); // преобразовали наш response в строку
        JsonPath jsonPath = new JsonPath(json);
        float actualResult = jsonPath.get("coord.lat");//получили значение элемента coord.lat
        assertThat(actualResult, is(equalTo(expectedResult))); // сравнили значение возвращаемое с сервиса, со значением, которое мы ожидаем*/
    }
}
