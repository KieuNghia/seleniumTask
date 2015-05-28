package Test.PageObjects.Yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nghia on 24.05.2015.
 */
public class LoginPage {


    private WebDriver driver;

    @FindBy(xpath = "//input[@name = 'login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type = 'password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement okButton;

    @FindBy(xpath = "//input[@id='next']")
    private WebElement nextButton;




    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public MailPage loginAs(String username, String password){

        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        okButton.click();

        return new MailPage(driver);


    }












}