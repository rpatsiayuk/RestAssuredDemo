package com.openweather.by_zip_code;

import com.openweather.BaseTest;
import com.openweather.builder.OpenWeatherBuilderRequest;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


/**
 * Created by Raman_Patsiayuk
 */
@Feature("City weather id by zip code")
public class VerifyCityWeatherIdByZipCodeTest extends BaseTest {
    //http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3
    //static final Logger LOGGER = Logger.getLogger(VerifyCityWeatherIdByZipCodeTest.class);

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    public void verifyCityGeoLocationLatitudeTest() {
        String request = new OpenWeatherBuilderRequest().setZip("94040,us").build();

        String expectedResult = "500";
        Response response = get(request);
        assertThat(response.getStatusCode(), is(equalTo(200))); //проверили, что сервис возвращает на статус 200 ОК
        String json = response.asString(); // преобразовали наш response в строку
        JsonPath jsonPath = new JsonPath(json);
        String actualResult = String.valueOf(jsonPath.getList("weather.id").get(0));//получили значение элемента weather.id
        assertThat(actualResult, is(equalTo(expectedResult))); // сравнили значение возвращаемое с сервиса, со значением, которое мы ожидаем
    }
}
