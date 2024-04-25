package org.github.bubochkana.service.placeholder.endpoints;

import io.restassured.specification.RequestSpecification;
import org.github.bubochkana.models.users.UserRequestDto;
import org.github.bubochkana.models.users.UserResponseDto;
import org.github.bubochkana.service.common.AbstractWebEndpoint;

public class UserEndpoint extends AbstractWebEndpoint {
    public UserEndpoint(RequestSpecification requestSpecification){
        super(requestSpecification);
    }
    public UserResponseDto create(UserRequestDto userRequestDto) {
        return post(
                this.requestSpecification,
                "users",
                userRequestDto)
                .extract().as(UserResponseDto.class);

    }
}
