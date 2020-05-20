package io.sprintboards.pages.createboard;
import org.openqa.selenium.By;

public class CreateBoardPageLocators {

    public static final By SESSION_NAME_XPATH         = By.xpath("//input[@placeholder='Session Name']");
    public static final By BOARD_OWNER_DROPDOWN       = By.className("custom-select");
    public static final By CREATE_BOARD_BTN_XPATH     = By.xpath("//button[@type='submit' and text()='Create Board']");
    public static final By CREATE_BOARD_H1_TITLE      = By.tagName("h1");
    public static final By CONFIRMATION_POPUP_MESSAGE = By.cssSelector("body>div.swal-overlay>div>div.swal-title");

}
