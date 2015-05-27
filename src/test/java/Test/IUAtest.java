package Test;

import Test.PageObjects.IUA.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

/**
 * Created by nghia on 24.05.2015.
 */
public class IUAtest {


    private static final String START_URL = "http://mail.i.ua/";
    private static final String LOGIN = "Jekaufo";
    private static final String PASSWORD = "Password123";
    private static final String DOMAIN = "";

    private static final String LETTER_SUBJECT = "nichego";
    private static final String LETTER_BODY = "onetwo";
    private static final String LETTER_DEST = "mnikto1@yahoo.com";

    private WebDriver driver = new FirefoxDriver();
    MailPage mailPage = new MailPage(driver);
    LoginPage page = new LoginPage(driver);
    DraftPage draftPage = new DraftPage(driver);
    CreateMailPage createMailPage = new CreateMailPage(driver);


    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        driver.get(START_URL);
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicitly")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    private boolean isElementPresent(By by) {
        return !driver.findElements(by).isEmpty();
    }


    @Test(description = "login to mail")
    public void login() {

        page.loginAs(LOGIN, PASSWORD);
        Assert.assertTrue(isElementPresent(By.xpath("//span[text()='Jekaufo@i.ua']")));


    }

    @Test(dependsOnMethods = "login", description = "create letter")
    public void createLetter() {

        mailPage.createMail().saveDraft(LETTER_DEST, LETTER_SUBJECT, LETTER_BODY);


    }

    @Test(dependsOnMethods = "createLetter", description = "check letter in draft ")
    public void checkLetterInDraft() {

        mailPage.moveToDraft().checkLetterPresent(LETTER_SUBJECT).goToLetter(LETTER_SUBJECT);


    }

    @Test(dependsOnMethods = "checkLetterInDraft", description = "send letter in draft")
    public void sendLetter() {

        createMailPage.sendLetter();


    }

    @Test(dependsOnMethods = "sendLetter", description = "check letter in draft")
    public void checkLetterAbsentInDraft() {

        mailPage.moveToDraft();
        Assert.assertFalse(isElementPresent((By.xpath("//span[text()='" + LETTER_SUBJECT + "']"))));


    }


    @Test(dependsOnMethods = "checkLetterAbsentInDraft", description = "check letter in sent folder")
    public void checkLetterInSentFolder() {


        mailPage.moveToSent();
        Assert.assertTrue(isElementPresent((By.xpath("//span[text()='" + LETTER_SUBJECT + "']"))));

    }

    @AfterClass
    public void exit(){
       draftPage.goToMainPage().quit();
        driver.quit();


    }


}
