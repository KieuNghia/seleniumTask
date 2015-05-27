package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

/**
 * Created by nghia on 27.05.2015.
 */
public class OperaDriverBuilder {


    private static WebDriver driver = null;

    public WebDriver createDriver() {
        System.setProperty("webdriver.opera.driver", "Libdrivers\\operadriver32.exe");
        driver = new OperaDriver();
        return  driver;

    }
}
