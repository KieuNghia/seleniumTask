package pageObjects.iUA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.Page;
import pageObjects.PageObjectSupport;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class DraftPage extends Page {


    public DraftPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//ul[@class='ho_menu ho_menu-main']//li[@class='ho_menu_item']/a")
    private WebElement toMainPageButton;

    public DraftPage checkLetterPresent(String topic) {
        Assert.assertTrue(PageObjectSupport.isElementPresent((By.xpath("//span[text()='" + topic + "']"))));

        return new DraftPage(driver);
    }

    public CreateMailPage goToLetter(String topic) {

        driver.findElement(By.xpath("//span[text()='" + topic + "']")).click();

        return new CreateMailPage(driver);


    }

    public LoginPage goToMainPage() {

        toMainPageButton.click();

        return new LoginPage(driver);

    }

    public void checkLetterAbsent(String subject) {

        Assert.assertFalse(PageObjectSupport.isElementPresent((By.xpath("//span[text()='" + subject + "']"))));

    }


}



