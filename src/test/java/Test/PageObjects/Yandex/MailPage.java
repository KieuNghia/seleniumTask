package Test.PageObjects.Yandex;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//span[text() = 'Написать']")
    private WebElement createMailButton;

    @FindBy(xpath = "//a[contains(@href, '#draft')]")
    private WebElement draftButton;

    @FindBy(xpath = "//a[contains(@href, '#sent')]")
    private WebElement sentButton;





    public DraftPage checkLetterPresent(String topic){
        draftButton.click();
        driver.findElement(By.xpath("//span[@title='" + topic + "']"));

        return new DraftPage(driver);
    }

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
