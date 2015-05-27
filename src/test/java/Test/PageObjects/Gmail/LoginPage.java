package Test.PageObjects.Gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nghia on 24.05.2015.
 */
public class LoginPage {


    private WebDriver driver;

    @FindBy(xpath = "//input[@id = 'Email']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@id = 'Passwd']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signIn']")
    private WebElement okButton;

    @FindBy(xpath = "//input[@id='next']")
    private WebElement nextButton;




    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public MailPage loginAs(String username, String password){

        loginField.sendKeys(username);
       // nextButton.click();
        passwordField.sendKeys(password);
        okButton.click();

        return new MailPage(driver);


    }












}