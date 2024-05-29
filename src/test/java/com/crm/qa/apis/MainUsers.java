package com.crm.qa.apis;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class MainUsers {
    public static void main(String[] args) {
        RestAssured.baseURI="https://reqres.in/api/";
        String response = given()
                .log()
                .all()
                .header("accept", "application/json")
                .when()
                .get("{resource}")
                .then()
                .log()
                .all()
                .assertThat()
                .statusCode(200).extract()
                .response()
                .asString();
    }
}
