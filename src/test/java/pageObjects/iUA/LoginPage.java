package pageObjects.iUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;

/**
 * Created by nghia on 24.05.2015.
 */
public class LoginPage extends Page {


    public LoginPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement okButton;

    @FindBy(xpath = "//li[@class = 'right']//a")
    private WebElement logoutButton;

    public LoginPage loginInsert(String username) {
        loginField.sendKeys(username);
        return new LoginPage(driver);
    }

    public LoginPage passwordInsert(String password) {
        passwordField.sendKeys(password);
        return new LoginPage(driver);

    }

    public MailPage clickOk() {

        okButton.click();
        return new MailPage (driver);
    }


    public void quit() {
        logoutButton.click();
    }



}
