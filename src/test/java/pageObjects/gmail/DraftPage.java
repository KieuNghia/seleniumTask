package pageObjects.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.Page;

/**
 * Created by Kuanh_Nhkhiia_Kiieu on 5/25/2015.
 */
public class DraftPage extends Page {


    public DraftPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }


    public DraftPage checkLetterPresent(String topic) {
        driver.findElement(By.xpath("//span[text()='" + topic + "']"));

        return new DraftPage(driver);
    }

    public CreateMailPage goToLetter(String topic) {

        driver.findElement(By.xpath("//span[text()='" + topic + "']")).click();

        return new CreateMailPage(driver);


    }

    public void checkLetterAbsent(String subject) {


        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + subject + "']")).getText(), subject);


    }


}



