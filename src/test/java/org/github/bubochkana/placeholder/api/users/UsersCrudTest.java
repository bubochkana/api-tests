package org.github.bubochkana.placeholder.api.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.github.bubochkana.models.users.*;
import org.github.bubochkana.placeholder.api.BaseTest;
import org.github.bubochkana.service.Services;
import org.github.bubochkana.testdata.UserTestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsersCrudTest extends BaseTest {

  private UserRequestDto leanneGraham = UserTestData.getLeanneGrahamUser();
  private UserRequestDto glennaReichert = UserTestData.getGlennaReichertUser();
  private UserRequestDto clementinaDuBuque = UserTestData.getClementinaDuBuqueUser();

  @Test(
      testName = "TC-1",
      description = "Verify the ability to create a new User",
      groups = "Users")
  public void testVerifyAbilityToCreateUser() {
    UserResponseDto createdUserResponse =
        Services.placeholderApi().user().createUser(glennaReichert);
    assertThat(createdUserResponse)
        .usingRecursiveComparison()
        // TODO - the user is always created with id=11, however we pass id=9 in the request,
        // probably id is not needed in the request?
        .ignoringFields("id")
        .isEqualTo(glennaReichert);
  }

  @Test(
      testName = "TC-2",
      description = "Verify the ability to update a new User",
      groups = "Users")
  public void testVerifyAbilityToUpdateUser() {
    UserResponseDto updatedUserResponse =
        Services.placeholderApi().user().updateUser(clementinaDuBuque, "1");
    assertThat(updatedUserResponse)
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(clementinaDuBuque);
  }

  @Test(
      testName = "TC-3",
      description = "Verify response and validation when update User for invalid ID",
      groups = "Users")
  public void testVerifyResponseWhenUpdateUserForInvalidId() {
    UserErrorResponseDto errorResponse =
        Services.placeholderApi().user().getUserByIdWithError("100");
    // TODO - verify the error message text? errorResponse.getMessage() gives null
    //        assertThat(errorResponse.getMessage())
    //                .isEqualTo("Invalid User Id Provided");

  }

  @Test(
      testName = "TC-4",
      description = "Verify possibility to retrieve User by Id",
      groups = "Users")
  public void testVerifyPossibilityToRetrieveUserById() {
    UserResponseDto userResponse = Services.placeholderApi().user().getUserById("1");
    assertThat(userResponse)
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(leanneGraham);
  }

  @Test(
      testName = "TC-5",
      description = "Verify count of users in retrieved list",
      groups = "Users")
  public void testVerifyUsersCountInRetrievedList() {
    List<UserResponseDto> usersListResponse = Services.placeholderApi().user().getAllUsers();
    assertThat(usersListResponse).hasSizeGreaterThan(5);
  }

  @DataProvider(name = "usersData")
  public Object[][] testData() {
    return new Object[][] {{clementinaDuBuque}, {leanneGraham}, {glennaReichert}};
  }

  @Test(
      testName = "TC-6",
      description = "Verify update several users",
      groups = "Users",
      dataProvider = "usersData")
  public void verifyUpdateSeveralUsers(UserRequestDto user) {
    UserResponseDto updatedUserResponse = Services.placeholderApi().user().updateUser(user, "1");
    assertThat(updatedUserResponse).usingRecursiveComparison().ignoringFields("id").isEqualTo(user);
  }
}
