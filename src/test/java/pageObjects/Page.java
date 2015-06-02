package pageObjects;

import drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * Created by nghia on 02.06.2015.
 */
public abstract class Page extends PageObjectSupport {


    protected final WebDriver driver;

    protected String title;

    protected String url;

    public Page(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
        title = driver.getTitle();

    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected void setUrl(String url) {
        this.url = url;
    }

    protected String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public Page goToPage() {
        driver.get(url);
        title = driver.getTitle();
        return this;
    }
}

