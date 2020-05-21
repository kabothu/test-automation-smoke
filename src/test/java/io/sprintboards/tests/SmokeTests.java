package io.sprintboards.tests;

import io.qameta.allure.*;
import io.sprintboards.basetest.BaseTest;
import io.sprintboards.constants.BusinessConstants;
import io.sprintboards.constants.Groups;
import io.sprintboards.listeners.TestAllureListener;
import io.sprintboards.pages.createboard.CreateBoardPage;
import io.sprintboards.pages.board.BoardPage;
import io.sprintboards.pages.home.HomePage;
import io.sprintboards.pages.login.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Story("Board Page functionality")
@Listeners({TestAllureListener.class})
@Owner("Surendra Singh")
@Epic("Create board feature implementation")
@Feature("Create board, add/delete cards, likes for card")
public class SmokeTests extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    CreateBoardPage createBoardPage;
    BoardPage boardPage;

    SmokeTests() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        createBoardPage = new CreateBoardPage();
        boardPage = new BoardPage();
    }

    @Description("create a board, add green and red cards, like in green card, delete red card test")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1, groups = Groups.SPRINT_BOARD_SMOKE)
    public void creatingBoardAddDeleteCardLikesTest() {

        //Test data
        String boardName = "My first board";
        String greenCardTitle = "Goal was achieved";
        String greenCardDesc = "Sprint was well planned";
        String redCardTitle = "Goal was not achieved";

        //Creating board
        String userEmail = prop.getProperty("userEmail");
        String password = prop.getProperty("password");
        loginPage.login(userEmail, password);
        homePage.clickCreateBoardLink();
        Assert.assertEquals(createBoardPage.getCreateBoardPageUrl(), BusinessConstants.CREATE_BOARD_PAGE_URL, "Create Page url is not correct");
        Assert.assertEquals(createBoardPage.getCreateBoardPageTitle(), BusinessConstants.CREATE_BOARD_PAGE_TITLE, "Create Page title mismatched");
        createBoardPage.enterSessionName(boardName);
        createBoardPage.selectBoardOwner(BusinessConstants.BOARD_OWNER);
        createBoardPage.clickCreateBoardButton();
        Assert.assertEquals(createBoardPage.getTextFromConfirmationPopUp(), BusinessConstants.BOARD_CREATED_SUCCESS_MESSAGE, "Confirmation pop-up is either not displayed or text is incorrect");
        Assert.assertTrue(boardPage.checkBoardsPageUrlContainsExpectedUrl(BusinessConstants.BOARDS_PAGE_URL));

        //Add green card
        boardPage.clickAddCardButtonForWentWellSection();
        String addCardModalTitle = boardPage.getAddCardModalTitle();
        Assert.assertEquals(addCardModalTitle, BusinessConstants.TITLE_ADD_CARD_MODAL, "Title for Add card modal is mismatched");
        boardPage.enterCardTitleOnAddCardModal(greenCardTitle);
        boardPage.enterCardDescriptionOnAddCardModal(greenCardDesc);
        boardPage.clickAddCardButtonOnAddCardModal();
        Assert.assertEquals(boardPage.getCardTitleFromWentWellSection(), greenCardTitle, "Green card title is mismatched");
        Assert.assertEquals(boardPage.getCardDescriptionFromWentWellSection(), greenCardDesc, "Green card description is mismatched");

        //Add red card
        boardPage.clickAddCardButtonForDidNotGoWellSection();
        Assert.assertEquals(boardPage.getAddCardModalTitle(), BusinessConstants.TITLE_ADD_CARD_MODAL, "Title for Add card modal is mismatched");
        boardPage.enterCardTitleOnAddCardModal(redCardTitle);
        boardPage.clickAddCardButtonOnAddCardModal();
        Assert.assertEquals(boardPage.getCardTitleFromDidNotGoWellSection(), redCardTitle, "Some error");
        Assert.assertEquals(boardPage.getCardDescriptionFromDidNotGoWellSection(), BusinessConstants.NO_DESCRIPTION_CARD, "Card’s description is not set to :No description provided");

        //Likes in green card
        boardPage.clickThumbsIconInWentWellSection();
        int likesCount = boardPage.getNumberOfLikesInWentWellSection();
        Assert.assertEquals(likesCount, 1, "Number of likes did not increase from 0 to 1");

        //Deleting red card
        boardPage.clickDeleteButtonInDidNotGoWellSection();
        Assert.assertEquals(boardPage.getDeleteCardModalTitle(), BusinessConstants.TITLE_DELETE_CARD_MODAL, "Title on delete card modal is mismatched");
        Assert.assertEquals(boardPage.getDeleteCardModalBody(), BusinessConstants.BODY_DELETE_CARD_MODAL, "Body on delete card modal is mismatched");
        boardPage.clickConfirmOnDeleteCardModal();
        Assert.assertTrue(boardPage.checkIfCardIsPresentInDidNotGoWellSection());
    }

    @Test
    public void test1(){
        System.out.println("hello");
        Assert.assertTrue(false);
    }
}
