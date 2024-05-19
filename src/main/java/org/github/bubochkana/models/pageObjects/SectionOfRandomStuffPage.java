package org.github.bubochkana.models.pageObjects;

import static com.codeborne.selenide.Selenide.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SectionOfRandomStuffPage extends BasePage {
  @FindBy(
      how = How.XPATH,
      using = "//div[contains(@class, 'et_pb_login_0')]//input[contains(@id, 'user_login_')]")
  private SelenideElement usernameFld;

  @FindBy(
      how = How.XPATH,
      using = "//div[contains(@class, 'et_pb_login_0')]//input[contains(@id, 'user_pass_')]")
  private SelenideElement passwordFld;

  @FindBy(
      how = How.XPATH,
      using =
          "//div[contains(@class, 'et_pb_login_0')]//button[contains(@name, 'et_builder_submit_button')]")
  private SelenideElement loginBtn;

  public SectionOfRandomStuffPage login(String username, String password) {
    usernameFld.setValue(username);
    passwordFld.setValue(password);
    loginBtn.click();
    return this;
  }

  public ErrorLoginPage loginWithError(String username, String password) {
    usernameFld.setValue(username);
    passwordFld.setValue(password);
    loginBtn.click();
    return page(ErrorLoginPage.class);
  }
}
