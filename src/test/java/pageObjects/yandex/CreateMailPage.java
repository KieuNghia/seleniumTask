package pageObjects.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class CreateMailPage extends Page{

    public CreateMailPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }
    private final String LETTER_SUBJECT = "nichego";

    @FindBy(xpath = "//div[contains(@class, 'mail-input')]//input[@type = 'text' and @data-nb]")
    private WebElement toField;

    @FindBy(xpath = "//input[@id = 'compose-subj']")
    private WebElement subjectField;

    @FindBy(xpath = "//textarea[@id = 'compose-send']")
    private WebElement textArea;

    /*@FindBy(xpath = "//a[@href='#draft']")
    private WebElement saveDraftButton;*/

    @FindBy(xpath = "//button[@id='compose-submit']")
    private WebElement sendButton;

    @FindBy(xpath = "//span[text() = 'Отменить'] ")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@data-action = 'dialog.save']")
    private WebElement saveButton;


    public CreateMailPage toFieldInsert(String to) {
        toField.sendKeys(to);
        return new CreateMailPage(driver);
    }

    public CreateMailPage subjectFieldInsert(String subject) {

        subjectField.sendKeys(subject);
        return new CreateMailPage(driver);
    }

    public CreateMailPage textAreaInsert(String text) {

        textArea.sendKeys(text);
        return new CreateMailPage(driver);
    }

    public MailPage saveDraft() {


        cancelButton.click();
        saveButton.click();

        return new MailPage(driver);
    }


    public MailPage sendLetter() {
        sendButton.click();
        return new MailPage(driver);

    }





}
