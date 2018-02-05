package com.openweather;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.After;
import org.junit.Before;

import static io.restassured.RestAssured.given;

/**
 * Created by Raman_Patsiayuk
 */
public class BaseTest {

    @Before
    public void setUp(){
        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5/";
        System.out.println("Method before run");
    }

    @After
    public void tearDown(){
        System.out.println("Method after run");
    }

    protected RequestSpecification getFilter() {
        return given().log()
                .all()
                .filter(new AllureRestAssured());
    }
}
