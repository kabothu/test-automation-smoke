package io.sprintboards.pages.login;

import io.qameta.allure.Step;
import io.sprintboards.utils.BrowserWait;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

import static io.sprintboards.pages.login.LoginPageLocators.*;
import static io.sprintboards.utils.BrowserActions.clearAndfillInFieldWith;
import static io.sprintboards.utils.BrowserActions.clickElementBy;


@Slf4j
public class LoginPage extends BrowserWait {


    @Step("login with user: {}")
    public void login(@NotNull String username, @NotNull String password) {
        log.info("login with user: {}", username);
        waitUntilElementIsPresent(EMAIL_XPATH);
        clearAndfillInFieldWith(EMAIL_XPATH, username);
        waitUntilElementIsPresent(PASSWORD_XPATH);
        clearAndfillInFieldWith(PASSWORD_XPATH, password);
        clickLoginButton();
    }

    public void clickLoginButton() {
        waitUntilElementClickable(LOGIN_BTN_XPATH);
        clickElementBy(LOGIN_BTN_XPATH);
    }
}
