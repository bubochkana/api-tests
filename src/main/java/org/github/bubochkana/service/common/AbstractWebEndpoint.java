package org.github.bubochkana.service.common;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public abstract class AbstractWebEndpoint {
  protected RequestSpecification requestSpecification;

  protected AbstractWebEndpoint() {}

  protected AbstractWebEndpoint(RequestSpecification requestSpecification) {
    this.requestSpecification = requestSpecification;
  }

  /**
   * Method to get the resource
   *
   * @param requestSpecification specifies the request parameters
   * @param path the resource path
   * @return ValidatableResponse
   */
  public ValidatableResponse get(RequestSpecification requestSpecification, String path) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    return RestAssured.given().spec(specBuilder.build()).when().get(path).then();
  }

  /**
   * @param requestSpecification specifies the request parameters
   * @param path the resource path
   * @param body request body to create the resource
   * @return ValidatableResponse
   */
  public ValidatableResponse post(
      RequestSpecification requestSpecification, String path, Object body) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    return RestAssured.given().spec(specBuilder.build()).body(body).when().post(path).then();
  }

  /**
   * @param requestSpecification specifies the request parameters
   * @param path the resource path
   * @param body request body to update the resource
   * @return ValidatableResponse
   */
  public ValidatableResponse put(
      RequestSpecification requestSpecification, String path, Object body) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    return RestAssured.given().spec(specBuilder.build()).body(body).when().put(path).then();
  }

  /**
   * @param requestSpecification specifies the request parameters
   * @param path the resource path
   * @return ValidatableResponse
   */
  public ValidatableResponse delete(RequestSpecification requestSpecification, String path) {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    specBuilder.addRequestSpecification(requestSpecification);
    return RestAssured.given().spec(specBuilder.build()).when().delete(path).then();
  }
}
