package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nghia on 02.06.2015.
 */
public class PageObjectSupport {
    protected static WebDriver driver;

    public static boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }

}
