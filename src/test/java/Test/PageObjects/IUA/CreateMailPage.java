package Test.PageObjects.IUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class CreateMailPage {

    private WebDriver driver;

    public CreateMailPage(WebDriver driver){
        this.driver = driver;
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



    public MailPage saveDraft(String to, String subject, String text){

        toField.sendKeys(to);
        subjectField.sendKeys(subject);
        textArea.sendKeys(text);
        saveDraftButton.click();

        return new MailPage(driver);


    }

    public MailPage sendLetter(){

        sendButton.click();

        return new MailPage(driver);


    }
}
