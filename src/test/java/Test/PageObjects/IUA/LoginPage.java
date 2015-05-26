package Test.PageObjects.IUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nghia on 24.05.2015.
 */
public class LoginPage {


    private WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement okButton;

    @FindBy(xpath = "//li[@class = 'right']//a")
    private WebElement logoutButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public MailPage loginAs(String username, String password) {
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        okButton.click();
        return new MailPage(driver);


    }

    public void quit() {
        logoutButton.click();
    }


}
