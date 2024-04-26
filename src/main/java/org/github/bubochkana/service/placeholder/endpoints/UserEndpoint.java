package org.github.bubochkana.service.placeholder.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.github.bubochkana.models.users.UserErrorResponseDto;
import org.github.bubochkana.models.users.UserRequestDto;
import org.github.bubochkana.models.users.UserResponseDto;
import org.github.bubochkana.service.common.AbstractWebEndpoint;

import java.util.List;

public class UserEndpoint extends AbstractWebEndpoint {
    private static final String USERS = "/users";
    private static final String USER_ID = USERS + "/%s";
    public UserEndpoint(RequestSpecification requestSpecification){
        super(requestSpecification);
    }
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return createUser(userRequestDto, 201)
                .extract().as(UserResponseDto.class);
    }

    public ValidatableResponse createUser(UserRequestDto userRequestDto, int statusCode) {
        return post(
                this.requestSpecification,
                USERS,
                userRequestDto)
                .statusCode(statusCode);
    }

    public UserResponseDto updateUser(UserRequestDto userUpdateRequest, String userIdToUpdate) {
        return updateUser(userUpdateRequest, userIdToUpdate, 200)
                .extract().as(UserResponseDto.class);
    }

    public ValidatableResponse updateUser(UserRequestDto userUpdateRequest, String userIdToUpdate, int statusCode) {
        return put(
                this.requestSpecification,
                String.format(USER_ID, userIdToUpdate),
                userUpdateRequest)
                .statusCode(statusCode);
    }

    public UserResponseDto getUserById(String userId) {
        return getUserById(
                userId, 200)
                .extract().as(UserResponseDto.class);
    }

    public UserErrorResponseDto getUserByIdWithError(String userId) {
        return getUserById(
                userId, 404)
                .extract().as(UserErrorResponseDto.class);
    }

    public ValidatableResponse getUserById(String userId, int statusCode) {
        return get(
                this.requestSpecification,
                String.format(USER_ID, userId))
                .statusCode(statusCode);
    }

    public List<UserResponseDto> getAllUsers() {
        return List.of(getAllUsers(
                200)
                .extract().as(UserResponseDto[].class));
    }

    public ValidatableResponse getAllUsers(int statusCode) {
        return get(
                this.requestSpecification,
                USERS).statusCode(statusCode);
    }
}
