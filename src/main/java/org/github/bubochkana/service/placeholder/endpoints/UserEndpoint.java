package org.github.bubochkana.service.placeholder.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.github.bubochkana.enums.HttpStatus;
import org.github.bubochkana.models.users.UserErrorResponseDto;
import org.github.bubochkana.models.users.UserRequestDto;
import org.github.bubochkana.models.users.UserResponseDto;
import org.github.bubochkana.service.common.AbstractWebEndpoint;

public class UserEndpoint extends AbstractWebEndpoint {
  private static final String USERS = "/users";
  private static final String USER_ID = USERS + "/%s";

  public UserEndpoint(RequestSpecification requestSpecification) {
    super(requestSpecification);
  }

  /**
   * Method to create a user
   *
   * @param userRequestDto the model with parameters to crete a user
   * @return UserResponseDto
   */
  public UserResponseDto createUser(UserRequestDto userRequestDto) {
    return createUser(userRequestDto, HttpStatus.CREATED).extract().as(UserResponseDto.class);
  }

  /**
   * Method to create a user
   *
   * @param userRequestDto the model with parameters to crete a user
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse createUser(UserRequestDto userRequestDto, HttpStatus statusCode) {
    return post(this.requestSpecification, USERS, userRequestDto)
        .statusCode(statusCode.getStatusCode());
  }

  /**
   * Method to update a user
   *
   * @param userUpdateRequest the model with parameters to update a user
   * @param userIdToUpdate the user id to update
   * @return UserResponseDto
   */
  public UserResponseDto updateUser(UserRequestDto userUpdateRequest, String userIdToUpdate) {
    return updateUser(userUpdateRequest, userIdToUpdate, HttpStatus.OK)
        .extract()
        .as(UserResponseDto.class);
  }

  /**
   * Method to update a user
   *
   * @param userUpdateRequest the model with parameters to update a user
   * @param userIdToUpdate the user id to update
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse updateUser(
      UserRequestDto userUpdateRequest, String userIdToUpdate, HttpStatus statusCode) {
    return put(this.requestSpecification, String.format(USER_ID, userIdToUpdate), userUpdateRequest)
        .statusCode(statusCode.getStatusCode());
  }

  /**
   * Method to get the user by id
   *
   * @param userId the user id to get
   * @return UserResponseDto
   */
  public UserResponseDto getUserById(String userId) {
    return getUserById(userId, HttpStatus.OK).extract().as(UserResponseDto.class);
  }

  /**
   * Method to get the invalid user
   *
   * @param userId the invalid user id to get
   * @return UserErrorResponseDto
   */
  public UserErrorResponseDto getUserByIdWithError(String userId) {
    return getUserById(userId, HttpStatus.NOT_FOUND).extract().as(UserErrorResponseDto.class);
  }

  /**
   * Method to get the user by id
   *
   * @param userId the user id to get
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse getUserById(String userId, HttpStatus statusCode) {
    return get(this.requestSpecification, String.format(USER_ID, userId))
        .statusCode(statusCode.getStatusCode());
  }

  /**
   * Method to get all users
   *
   * @return List of UserResponseDto
   */
  public List<UserResponseDto> getAllUsers() {
    return List.of(getAllUsers(HttpStatus.OK).extract().as(UserResponseDto[].class));
  }

  /**
   * Method to get all users
   *
   * @param statusCode the response code
   * @return ValidatableResponse
   */
  public ValidatableResponse getAllUsers(HttpStatus statusCode) {
    return get(this.requestSpecification, USERS).statusCode(statusCode.getStatusCode());
  }
}
