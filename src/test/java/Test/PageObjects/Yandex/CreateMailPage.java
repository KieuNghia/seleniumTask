package Test.PageObjects.Yandex;

import org.openqa.selenium.By;
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

    @FindBy (xpath = "//span[text() = 'Отменить'] " )
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@data-action = 'dialog.save']")
    private WebElement saveButton;



    public MailPage saveDraft(String to, String subject, String text){

        toField.sendKeys(to);
        subjectField.sendKeys(subject);
        textArea.sendKeys(text);
        cancelButton.click();
        saveButton.click();



        return new MailPage(driver);


    }

    public MailPage sendLetter(){

       // driver.findElement(By.xpath("//span[text()='" + LETTER_SUBJECT + "']")).click();

        sendButton.click();

        return new MailPage(driver);


    }
}
