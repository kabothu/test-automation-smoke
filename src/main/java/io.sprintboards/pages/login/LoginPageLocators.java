package io.sprintboards.pages.login;
import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By EMAIL_XPATH      = By.xpath("//input[@type='email']");
    public static final By PASSWORD_XPATH   = By.xpath("//input[@type='password']");
    public static final By LOGIN_BTN_XPATH  = By.xpath("//button[@type='submit' and text()='Login']");

}
