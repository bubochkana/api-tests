package users;


import io.restassured.response.Response;
import models.users.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class UsersTest extends BaseTest {
    private final UserRequest user1 = UserRequest.builder()
            .id(1)
            .name("Leanne Graham")
            .username("Bret")
            .email("Sincere@april.biz")
            .address(Address.builder()
                    .street("Kulas Light")
                    .suite("Apt. 556")
                    .city("Gwenborough")
                    .zipcode("92998-3874")
                    .geo(Geo.builder()
                            .lat("-37.3159")
                            .lng("81.1496")
                            .build())
                    .build())
            .phone("1-770-736-8031 x56442")
            .website("hildegard.org")
            .company(Company.builder()
                    .name("Romaguera-Crona")
                    .catchPhrase("Multi-layered client-server neural-net")
                    .bs("harness real-time e-markets")
                    .build())
            .build();
    private final UserRequest user9 = UserRequest.builder()
            .id(9)
            .name("Glenna Reichert")
            .username("Delphine")
            .email("Chaim_McDermott@dana.io")
            .address(Address.builder()
                    .street("Dayna Park")
                    .suite("Suite 449")
                    .city("Bartholomebury")
                    .zipcode("76495-3109")
                    .geo(Geo.builder()
                            .lat("24.6463")
                            .lng("-168.8889")
                            .build())
                    .build())
            .phone("(775)976-6794 x41206")
            .website("conrad.com")
            .company(Company.builder()
                    .name("Yost and Sons")
                    .catchPhrase("Switchable contextually-based project")
                    .bs("aggregate real-time technologies")
                    .build())
            .build();
    private final UserRequest user10 = UserRequest.builder()
            .id(10)
            .name("Clementina DuBuque")
            .username("Moriah.Stanton")
            .email("Rey.Padberg@karina.bizo")
            .address(Address.builder()
                    .street("Kattie Turnpike")
                    .suite("Suite 198")
                    .city("Lebsackbury")
                    .zipcode("31428-2261")
                    .geo(Geo.builder()
                            .lat("-38.2386")
                            .lng("57.2232")
                            .build())
                    .build())
            .phone("024-648-3804")
            .website("ambrose.net")
            .company(Company.builder()
                    .name("Hoeger LLC")
                    .catchPhrase("Centralized empowering task-force")
                    .bs("target end-to-end models")
                    .build())
            .build();


    @Test(groups = "Users")
    public void createUser() {
        Response response =
                given()
                        .body(user9)
                .when()
                        .post("users");

        assertThat(response.getStatusCode()).isEqualTo(201);
        assertThat(response.getBody().as(UserResponse.class))
                .usingRecursiveComparison()
                //TODO - the user is created with id=11, however we pass id=9 in the request, probably id is not needed in the request?
                .ignoringFields("id")
                .isEqualTo(user9);
    }

    @Test(groups = "Users")
    public void updateUser() {
        Response response =
                given()
                        .body(user10)
                .when()
                        .put("users/1");

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getBody().as(UserResponse.class))
                .usingRecursiveComparison()
                .ignoringFields("id")
                .isEqualTo(user10);
    }

    @Test(groups = "Users")
    public void getInvalidUser(){
        Response response =
                given()
                .when()
                        .get("users/100");

        assertThat(response.getStatusCode()).isEqualTo(404)
                //.withFailMessage()
        ;
        //TODO - verify the error message text? response.asString() gives "{}"

    }
    @Test(groups = "Users")
    public void getUser(){
        Response response =
                given()
                .when()
                        .get("users/1");

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.getBody().as(UserResponse.class))
                .usingRecursiveComparison()
                .isEqualTo(user1);
    }

    @Test(groups = "Users")
    public void getUsersCount(){
        Response response =
                given()
                .when()
                        .get("users");

        assertThat(response.getStatusCode()).isEqualTo(200);
        assertThat(response.as(UserResponse[].class).length).isGreaterThan(5);
    }
}
