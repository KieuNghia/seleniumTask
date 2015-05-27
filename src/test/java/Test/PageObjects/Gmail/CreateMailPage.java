package Test.PageObjects.Gmail;

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

    @FindBy(xpath = "//textarea[@aria-label  = 'Кому']")
    private WebElement toField;

    @FindBy(xpath = "//input[@placeholder = 'Тема']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label = 'Тело письма']")
    private WebElement textArea;

    @FindBy(xpath = "//a[text() = 'Черновики (1)']")
    private WebElement saveDraftButton;

    @FindBy(xpath = "//div[text() = 'Отправить']")
    private WebElement sendButton;



    public MailPage saveDraft(String to, String subject, String text){

        toField.sendKeys(to);
        subjectField.sendKeys(subject);
        textArea.sendKeys(text);
        textArea.click();

        return new MailPage(driver);


    }

    public MailPage sendLetter(){

       // driver.findElement(By.xpath("//span[text()='" + LETTER_SUBJECT + "']")).click();

        sendButton.click();

        return new MailPage(driver);


    }
}
