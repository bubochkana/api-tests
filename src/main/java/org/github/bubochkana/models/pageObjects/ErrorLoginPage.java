package org.github.bubochkana.models.pageObjects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

@Getter
public class ErrorLoginPage extends BasePage {
  @FindBy(how = How.ID, using = "login_error")
  private SelenideElement loginError;

  @FindBy(how = How.ID, using = "user_login")
  private SelenideElement usernameOrEmailAddressFld;

  @FindBy(how = How.ID, using = "user_pass")
  private SelenideElement passwordFld;
}
