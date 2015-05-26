package Test.PageObjects.IUA;

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


    public CreateLetterPage goToMail(String topic) {

        driver.findElement(By.xpath("//span[text()='" + topic + "']")).click();
        return new CreateLetterPage(driver);


    }


}


