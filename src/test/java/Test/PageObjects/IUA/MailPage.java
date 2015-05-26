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

    @FindBy(xpath = "//p[@class='make_message']//a")
    private WebElement createMailButton;

    @FindBy(xpath = "//ul[@class='list_underlined']//li[3]//a")
    private WebElement draftButton;

    @FindBy(xpath = "//ul[@class='list_underlined']//li[2]//a")
    private WebElement sentButton;




    public DraftPage moveToDraft() {

        draftButton.click();

        return new DraftPage(driver);


    }

    public DraftPage moveToSent() {

        sentButton.click();
        return new DraftPage(driver);
    }

    public CreateMailPage createMail() {
        createMailButton.click();

        return new CreateMailPage(driver);

    }


}
