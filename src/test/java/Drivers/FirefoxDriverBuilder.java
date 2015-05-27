package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by nghia on 27.05.2015.
 */
public class FirefoxDriverBuilder {


    private static WebDriver driver = null;

    public WebDriver createDriver() {
        driver = new FirefoxDriver();
        return driver;

    }
}
