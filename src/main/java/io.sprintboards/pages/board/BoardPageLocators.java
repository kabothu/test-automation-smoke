package io.sprintboards.pages.board;
import org.openqa.selenium.By;

public class BoardPageLocators {

    public static final By WENT_WELL_ADD_CARD_BTN_XPATH            = By.xpath("//span[text()='Went well']/following-sibling::button[2]");
    public static final By DIDNT_GO_WELL_ADD_CARD_BTN_XPATH        = By.xpath("//span[contains(text(),'go well')]//following-sibling::button[2]");
    public static final By TITLE_ADD_CARD_MODAL_XPATH              = By.xpath("//*[text()='Title']/following-sibling::p[2]/input");
    public static final By DESCRIPTION_ADD_CARD_MODAL_XPATH        = By.xpath("//*[text()='Description']/following-sibling::p/textarea");
    public static final By ADD_CARD_BTN_ADD_CARD_MODAL             = By.xpath("//button[@type='submit' and text()='Add Card']");
    public static final By ADD_CARD_MODAL_TITLE                    = By.xpath("//*[@id='add-card-modal']");
    public static final By THUMBS_ICON_WENT_WELL_CARD_XPATH        = By.xpath("(//*[@data-icon='thumbs-up'])[1]");
    public static final By LIKES_COUNT_ICON_WENT_WELL_CARD_XPATH   = By.xpath("(//*[@data-icon='thumbs-up']/..)[1]");
    public static final By DIDNT_GO_WELL_CARD_TITLE                = By.xpath("//span[contains(text(),'go well')]/../following-sibling::div/div/div/h6");
    public static final By WENT_WELL_CARD_TITLE                    = By.xpath("//span[contains(text(),'Went well')]/../following-sibling::div/div/div/h6");
    public static final By WENT_WELL_CARD_DESCRIPTION              = By.xpath("//span[contains(text(),'Went well')]/../following-sibling::div/div/div/div/p");
    public static final By DIDNT_GO_WELL_CARD_DESCRIPTION          = By.xpath("//span[contains(text(),'go well')]/../following-sibling::div/div/div/div/p");
    public static final By DIDNT_GO_WELL_DELETE_CARD_BTN           = By.xpath("//span[contains(text(),'go well')]/../following-sibling::div/div/div/div/div[2]/ul/li[2]/button");
    public static final By DELETE_CARD_MODAL_TITLE                 = By.xpath("//*[@class='modal-header']/div");
    public static final By DELETE_CARD_MODAL_BODY                  = By.xpath("//*[@class='modal-body']/p");
    public static final By CONFIRM_DELETE_CARD_BTN                 = By.xpath("//button[@class='btn btn-danger' and text()='Confirm']");

}
