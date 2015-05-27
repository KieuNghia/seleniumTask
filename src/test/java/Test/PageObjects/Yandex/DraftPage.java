package Test.PageObjects.Yandex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class DraftPage {


    private WebDriver driver;

    public DraftPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text() = 'testmailbox.test@yandex.ru']")
    public WebElement accountDropDown;

    @FindBy(xpath = "//a[text()= 'Выход']")
    public WebElement quitButton;


    public CreateMailPage goToLetter(String topic) {

        driver.findElement(By.xpath("//span[@title='" + topic + "']")).click();

        return new CreateMailPage(driver);


    }

    public DraftPage goToMainPage() {

        accountDropDown.click();
        return new DraftPage(driver);


    }

    public void quit() {
        quitButton.click();


    }


}



