package io.sprintboards.pages.board;

import io.qameta.allure.Step;
import io.sprintboards.utils.BrowserWait;
import lombok.extern.slf4j.Slf4j;
import javax.validation.constraints.NotNull;
import static io.sprintboards.pages.board.BoardPageLocators.*;
import static io.sprintboards.utils.BrowserActions.*;

@Slf4j
public class BoardPage extends BrowserWait {

    public boolean checkBoardsPageUrlContainsExpectedUrl(String url) {
        return checkIfUrlContainsSpecificText(url);
    }

    @Step("clicking on green-add card button for Went Well section")
    public void clickAddCardButtonForWentWellSection() {
        log.info("clicking on green-add card button for Went Well section");
        waitUntilElementClickable(WENT_WELL_ADD_CARD_BTN_XPATH);
        clickElementBy(WENT_WELL_ADD_CARD_BTN_XPATH);
    }

    @Step("clicking on red-add card button for Didn't go well section")
    public void clickAddCardButtonForDidNotGoWellSection() {
        log.info("clicking on red-add card button for Didn't go well section");
        waitUntilElementClickable(DIDNT_GO_WELL_ADD_CARD_BTN_XPATH);
        clickElementBy(DIDNT_GO_WELL_ADD_CARD_BTN_XPATH);
    }

    @Step("entering card title on add card modal as: {0}")
    public void enterCardTitleOnAddCardModal(@NotNull String cardTitle) {
        log.info("entering card title on add card modal as:{}", cardTitle);
        waitUntilElementIsPresent(TITLE_ADD_CARD_MODAL_XPATH);
        clearAndfillInFieldWith(TITLE_ADD_CARD_MODAL_XPATH, cardTitle);
    }

    @Step("entering card description on add card modal as: {0}")
    public void enterCardDescriptionOnAddCardModal(String cardDescription) {
        log.info("entering card description on add card modal as:{}", cardDescription);
        waitUntilElementIsPresent(DESCRIPTION_ADD_CARD_MODAL_XPATH);
        clearAndfillInFieldWith(DESCRIPTION_ADD_CARD_MODAL_XPATH, cardDescription);
    }

    @Step("clicking add card button on add card modal")
    public void clickAddCardButtonOnAddCardModal() {
        log.info("clicking add card button on add card modal");
        waitUntilElementClickable(ADD_CARD_BTN_ADD_CARD_MODAL);
        clickElementBy(ADD_CARD_BTN_ADD_CARD_MODAL);
    }

    public String getAddCardModalTitle() {
        log.info("getting add card modal title");
        waitUntilElementIsPresent(ADD_CARD_MODAL_TITLE);
        return getTextFromElement(ADD_CARD_MODAL_TITLE);
    }

    public String getCardTitleFromWentWellSection() {
        log.info("getting card title from Went Well section");
        waitUntilElementIsPresent(WENT_WELL_CARD_TITLE);
        return getTextFromElement(WENT_WELL_CARD_TITLE);
    }

    public String getCardTitleFromDidNotGoWellSection() {
        log.info("getting card title from Didn't go well section");
        waitUntilElementIsPresent(DIDNT_GO_WELL_CARD_TITLE);
        return getTextFromElement(DIDNT_GO_WELL_CARD_TITLE);
    }

    public String getCardDescriptionFromWentWellSection() {
        log.info("getting card description from Went Well section");
        waitUntilElementIsPresent(WENT_WELL_CARD_DESCRIPTION);
        return getTextFromElement(WENT_WELL_CARD_DESCRIPTION);
    }

    public String getCardDescriptionFromDidNotGoWellSection() {
        log.info("getting card description from Didn't go well section");
        waitUntilElementIsPresent(DIDNT_GO_WELL_CARD_DESCRIPTION);
        return getTextFromElement(DIDNT_GO_WELL_CARD_DESCRIPTION);
    }

    @Step("clicking on thumbs up icon in Went Well section")
    public void clickThumbsIconInWentWellSection() {
        log.info("clicking on thumbs up icon in Went Well section");
        try {
            waitUntilElementClickable(THUMBS_ICON_WENT_WELL_CARD_XPATH);
            clickElementBy(THUMBS_ICON_WENT_WELL_CARD_XPATH);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Integer getNumberOfLikesInWentWellSection() {
        log.info("getting number of likes in Went Well section");
            waitUntilElementIsDisplayed(THUMBS_ICON_WENT_WELL_CARD_XPATH);
            waitUntilElementIsDisplayed(LIKES_COUNT_ICON_WENT_WELL_CARD_XPATH);
            return getNumberFromElement(LIKES_COUNT_ICON_WENT_WELL_CARD_XPATH);
    }

    @Step("clicking on delete button in Didn't go well section")
    public void clickDeleteButtonInDidNotGoWellSection() {
        log.info("clicking on delete button in Didn't go well section");
        waitUntilElementClickable(DIDNT_GO_WELL_DELETE_CARD_BTN);
        clickElementBy(DIDNT_GO_WELL_DELETE_CARD_BTN);
    }

    public String getDeleteCardModalTitle() {
        log.info("getting delete card modal title");
        waitUntilElementIsPresent(DELETE_CARD_MODAL_TITLE);
        return getTextFromElement(DELETE_CARD_MODAL_TITLE);
    }

    public String getDeleteCardModalBody() {
        log.info("getting delete card modal body text");
        waitUntilElementIsPresent(DELETE_CARD_MODAL_BODY);
        return getTextFromElement(DELETE_CARD_MODAL_BODY);
    }

    @Step("clicking on confirm button on delete card modal")
    public void clickConfirmOnDeleteCardModal() {
        log.info("clicking on confirm button on delete card modal");
        waitUntilElementClickable(CONFIRM_DELETE_CARD_BTN);
        clickElementBy(CONFIRM_DELETE_CARD_BTN);
    }

    public boolean checkIfCardIsPresentInDidNotGoWellSection() {
        log.info("checking if card is present in Didn't go well section ");
        return isElementPresent(DIDNT_GO_WELL_CARD_TITLE);
    }


}
