package Test.PageObjects.IUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class MailPage {


    private WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//a[text()='Создать письмо']/@href")
    private WebElement createMailButton;

    @FindBy(xpath = "//a[text()='Черновики']/@href")
    private WebElement draftButton;

    @FindBy(xpath = "//a[text()='Отправленные']/@href")
    private WebElement sentButton;



    public DraftPage MoveToDraft() {

        draftButton.click();

        return new DraftPage(driver);


    }

    public DraftPage MoveToSent(){

        sentButton.click();
        return new DraftPage(driver);
    }




}
