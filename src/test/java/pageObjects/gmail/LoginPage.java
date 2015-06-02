package pageObjects.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Page;
import pageObjects.iUA.*;

/**
 * Created by nghia on 24.05.2015.
 */
public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver, driver.getCurrentUrl());
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//input[@id = 'Email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'Passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signIn']")
    private WebElement okButton;

    @FindBy(xpath = "//input[@id='next']")
    private WebElement nextButton;


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
        return new MailPage(driver);
    }


}


