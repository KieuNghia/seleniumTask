package pageObjects.iUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class CreateMailPage extends Page {

    public CreateMailPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"to\"]")
    private WebElement toField;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//*[@id=\"text\"]")
    private WebElement textArea;

    @FindBy(xpath = "//input[@name = 'save_in_drafts']")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//input[@name = 'send']")
    private WebElement sendButton;


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

        saveDraftButton.click();


        return new MailPage(driver);
    }


    public MailPage sendLetter() {
        sendButton.click();
        return new MailPage(driver);

    }


}
