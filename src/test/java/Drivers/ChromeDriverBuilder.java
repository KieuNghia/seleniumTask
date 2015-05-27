package Drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverBuilder {

    private static WebDriver driver = null;

    public WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", "Libdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        return  driver;

    }
}
