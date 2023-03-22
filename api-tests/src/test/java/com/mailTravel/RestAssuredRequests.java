package com.mailTravel;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredRequests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://dummy.restapiexample.com";
    }

    @Test
    public void getRequest() {
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/api/v1/employees")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
       // Assert.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));
    }
}