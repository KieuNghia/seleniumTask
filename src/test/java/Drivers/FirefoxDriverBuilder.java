package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxDriverBuilder {


    private static WebDriver driver = null;

    public WebDriver createDriver() {
        driver = new FirefoxDriver();
        return driver;

    }
}
