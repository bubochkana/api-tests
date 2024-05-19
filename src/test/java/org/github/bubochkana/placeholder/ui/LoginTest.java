package org.github.bubochkana.placeholder.ui;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

import org.github.bubochkana.models.pageObjects.ErrorLoginPage;
import org.github.bubochkana.models.pageObjects.SectionOfRandomStuffPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseUiTest {

  @DataProvider(name = "failedLoginData")
  public Object[][] testData() {
    String username = "anna";
    return new Object[][] {
      {"anna", "P@ssw0rd", "Error: The username %s".formatted(username)},
      {"1a2b3c", "", "Error: The password field is empty."},
      {"", "", "Error: The username field is empty. Error: The password field is empty."}
    };
  }

  @Test(
      testName = "TC-1",
      description = "Verify failed user login",
      groups = "Users",
      dataProvider = "failedLoginData")
  public void userFailedLogin(String username, String password, String errorMessage) {
    SectionOfRandomStuffPage sectionOfRandomStuffPage =
        open(getUrl(), SectionOfRandomStuffPage.class);
    ErrorLoginPage errorLoginPage = sectionOfRandomStuffPage.loginWithError(username, password);
    errorLoginPage.getLoginError().shouldHave(text(errorMessage));
  }
}
