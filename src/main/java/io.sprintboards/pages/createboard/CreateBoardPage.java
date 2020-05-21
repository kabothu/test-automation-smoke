package io.sprintboards.pages.createboard;

import io.qameta.allure.Step;
import io.sprintboards.utils.BrowserWait;
import lombok.extern.slf4j.Slf4j;
import javax.validation.constraints.NotNull;
import static io.sprintboards.pages.createboard.CreateBoardPageLocators.*;
import static io.sprintboards.utils.BrowserActions.*;

@Slf4j
public class CreateBoardPage extends BrowserWait {


    public String getCreateBoardPageTitle() {
        log.info("getting create board page title");
        return getTextFromElement(CREATE_BOARD_H1_TITLE);
    }

    public String getCreateBoardPageUrl() {
        log.info("getting create board page url");
        return getPageURL();
    }

    @Step("entering session name as: {0}")
    public void enterSessionName(@NotNull String sessionName) {
        log.info("entering card title on add card modal as:{}", sessionName);
        waitUntilElementIsPresent(SESSION_NAME_XPATH);
        clearAndfillInFieldWith(SESSION_NAME_XPATH, sessionName);
    }

    @Step("selecting board owner as:{0}")
    public void selectBoardOwner(@NotNull String owner) {
        log.info("selecting board owner as:{}", owner);
        waitUntilElementIsPresent(BOARD_OWNER_DROPDOWN);
        selectFromDropDownByVisibleText(BOARD_OWNER_DROPDOWN, owner);
    }

    @Step("clicking on create board button")
    public void clickCreateBoardButton() {
        log.info("clicking on create board button");
        waitUntilElementClickable(CREATE_BOARD_BTN_XPATH);
        clickElementBy(CREATE_BOARD_BTN_XPATH);
    }

    public String getTextFromConfirmationPopUp() {
        log.info("capturing success text from confirmation pop-up");
        waitUntilElementIsDisplayed(CONFIRMATION_POPUP_MESSAGE);
        return getTextFromElement(CONFIRMATION_POPUP_MESSAGE);
    }

}
