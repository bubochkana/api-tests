package users;

import org.github.bubochkana.models.users.*;
import org.github.bubochkana.service.Services;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest extends BaseTest {
    private final UserRequestDto user1 = UserRequestDto.builder()
            .id(1)
            .name("Leanne Graham")
            .username("Bret")
            .email("Sincere@april.biz")
            .address(AddressDto.builder()
                    .street("Kulas Light")
                    .suite("Apt. 556")
                    .city("Gwenborough")
                    .zipcode("92998-3874")
                    .geo(GeoDto.builder()
                            .lat("-37.3159")
                            .lng("81.1496")
                            .build())
                    .build())
            .phone("1-770-736-8031 x56442")
            .website("hildegard.org")
            .company(CompanyDto.builder()
                    .name("Romaguera-Crona")
                    .catchPhrase("Multi-layered client-server neural-net")
                    .bs("harness real-time e-markets")
                    .build())
            .build();
    private final UserRequestDto user9 = UserRequestDto.builder()
            .id(9)
            .name("Glenna Reichert")
            .username("Delphine")
            .email("Chaim_McDermott@dana.io")
            .address(AddressDto.builder()
                    .street("Dayna Park")
                    .suite("Suite 449")
                    .city("Bartholomebury")
                    .zipcode("76495-3109")
                    .geo(GeoDto.builder()
                            .lat("24.6463")
                            .lng("-168.8889")
                            .build())
                    .build())
            .phone("(775)976-6794 x41206")
            .website("conrad.com")
            .company(CompanyDto.builder()
                    .name("Yost and Sons")
                    .catchPhrase("Switchable contextually-based project")
                    .bs("aggregate real-time technologies")
                    .build())
            .build();
    private final UserRequestDto user10 = UserRequestDto.builder()
            .id(10)
            .name("Clementina DuBuque")
            .username("Moriah.Stanton")
            .email("Rey.Padberg@karina.bizo")
            .address(AddressDto.builder()
                    .street("Kattie Turnpike")
                    .suite("Suite 198")
                    .city("Lebsackbury")
                    .zipcode("31428-2261")
                    .geo(GeoDto.builder()
                            .lat("-38.2386")
                            .lng("57.2232")
                            .build())
                    .build())
            .phone("024-648-3804")
            .website("ambrose.net")
            .company(CompanyDto.builder()
                    .name("Hoeger LLC")
                    .catchPhrase("Centralized empowering task-force")
                    .bs("target end-to-end models")
                    .build())
            .build();


    @Test(groups = "Users")
    public void createUser() {
        UserResponseDto createdUserResponse = Services.placeholderApi().user().createUser(user9);
        assertThat(createdUserResponse)
                .usingRecursiveComparison()
                //TODO - the user is always created with id=11, however we pass id=9 in the request, probably id is not needed in the request?
                .ignoringFields("id")
                .isEqualTo(user9);
    }

    @Test(groups = "Users")
    public void updateUser() {
        UserResponseDto updatedUserResponse = Services.placeholderApi().user().updateUser(user10, "1");
        assertThat(updatedUserResponse)
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(user10);
    }

    @Test(groups = "Users")
    public void getInvalidUser(){
        UserErrorResponseDto errorResponse = Services.placeholderApi().user().getUserByIdWithError("100");
        //TODO - verify the error message text? errorResponse.getMessage() gives null
//        assertThat(errorResponse.getMessage())
//                .isEqualTo("Invalid User Id Provided");


    }
    @Test(groups = "Users")
    public void getUser(){
        UserResponseDto userResponse = Services.placeholderApi().user().getUserById("1");
        assertThat(userResponse)
                .usingRecursiveComparison()
                .isEqualTo(user1);
    }

    @Test(groups = "Users")
    public void getUsersCount(){
        List<UserResponseDto> usersListResponse = Services.placeholderApi().user().getAllUsers();
        assertThat(usersListResponse).hasSizeGreaterThan(5);
    }
}
