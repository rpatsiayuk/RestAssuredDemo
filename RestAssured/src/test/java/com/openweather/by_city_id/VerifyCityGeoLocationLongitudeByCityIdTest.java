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
}
