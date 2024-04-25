package org.github.bubochkana.service.common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractWebEndpoint {
    protected RequestSpecification requestSpecification;
    protected AbstractWebEndpoint(){
    }
    protected AbstractWebEndpoint(RequestSpecification requestSpecification){
        this.requestSpecification = requestSpecification;
    }
    public ValidatableResponse get(RequestSpecification requestSpecification, String path) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        return RestAssured.given()
                .spec(specBuilder.build())
                .when()
                .get(path)
                .then();
    }

    public ValidatableResponse post(RequestSpecification requestSpecification, String path, Object body) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        return RestAssured.given()
                .log().all()
                .spec(specBuilder.build())
                .log().all()
                .body(body)
                .log().all()
                .when()
                .log().all()
                .post(path)
                .then()
                .log().all();
    }

    public ValidatableResponse put(RequestSpecification requestSpecification, String path, String body) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        return RestAssured.given()
                .spec(specBuilder.build())
                .body(body)
                .when()
                .put(path)
                .then();
    }

    public ValidatableResponse delete(RequestSpecification requestSpecification, String path) {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder();
        specBuilder.addRequestSpecification(requestSpecification);
        return RestAssured.given()
                .spec(specBuilder.build())
                .when()
                .delete(path)
                .then();
    }
}
