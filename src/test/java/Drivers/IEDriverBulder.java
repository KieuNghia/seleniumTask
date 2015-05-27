package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by nghia on 27.05.2015.
 */
public class IEDriverBulder {


    private static WebDriver driver = null;

    public WebDriver createDriver() {
        System.setProperty("webdriver.ie.driver", "Libdrivers\\IEDriverServer64.exe");
        driver = new InternetExplorerDriver();
        return driver;

    }
}
