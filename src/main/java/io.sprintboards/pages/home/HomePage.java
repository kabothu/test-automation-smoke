package io.sprintboards.pages.home;

import io.qameta.allure.Step;
import io.sprintboards.utils.BrowserWait;
import lombok.extern.slf4j.Slf4j;

import static io.sprintboards.pages.home.HomePageLocators.CREATE_BOARD_LINK_TEXT;
import static io.sprintboards.utils.BrowserActions.*;

@Slf4j
public class HomePage extends BrowserWait {

    @Step("clicking create board link")
    public void clickCreateBoardLink() {
        log.info("clicking create board link");
        waitUntilElementClickable(CREATE_BOARD_LINK_TEXT);
        clickElementBy(CREATE_BOARD_LINK_TEXT);
    }

}
