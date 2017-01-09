package com.openweather.by_city_name;

import com.openweather.BaseTest;
import com.openweather.builder.OpenWeatherBuilderRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


/**
 * Created by Raman_Patsiayuk
 */
public class VerifyCityGeoLocationLatitudeByCityNameXmlTest extends BaseTest {
    //http://api.openweathermap.org/data/2.5/weather?q=Brest,by&APPID=c893442b753870781d1f92e6457cd9a3
    static final Logger LOGGER = Logger.getLogger(VerifyCityGeoLocationLatitudeByCityNameXmlTest.class);

    @Test
    public void verifyCityGeoLocationLatitudeTest() {
        String request = new OpenWeatherBuilderRequest().setCityName("Brest,by").setMode("xml").build();

        float expectedResult = Float.parseFloat("52.1");
        Response response = get(request);
        LOGGER.info(response.asString());
        assertThat(response.getStatusCode(), is(equalTo(200))); //проверили, что сервис возвращает на статус 200 ОК
        String xml = response.asString(); // преобразовали наш response в строку
        XmlPath xmlPath = new XmlPath(xml);
        float actualResult = xmlPath.get("coord.lat");//получили значение элемента coord.lat
        assertThat(actualResult, is(equalTo(expectedResult))); // сравнили значение возвращаемое с сервиса, со значением, которое мы ожидаем
    }
}
