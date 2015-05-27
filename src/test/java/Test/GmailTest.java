package Test;

import Test.PageObjects.Gmail.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.util.concurrent.TimeUnit;

/**
 * Created by nghia on 24.05.2015.
 */
public class GmailTest {


    private static final String START_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl";
    private static final String LOGIN = "petrov.vas123321123@gmail.com";
    private static final String PASSWORD = "123an123";
    private static final String DOMAIN = "";

    private static final String LETTER_SUBJECT = "nichego";
    private static final String LETTER_BODY = "onetwo";
    private static final String LETTER_DEST = "nghia_hiep04@yahoo.com";
    private static final String ACCOUNT_BUTTON ="";

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

        Assert.assertEquals(driver.findElement(By.xpath("//span[text()='" + LETTER_SUBJECT + "']")).getText(), LETTER_SUBJECT);


    }


    @Test(dependsOnMethods = "checkLetterAbsentInDraft", description = "check letter in sent folder")
    public void checkLetterInSentFolder() {


        mailPage.moveToSent();
        Assert.assertTrue(isElementPresent(By.xpath("//span[text()='" + LETTER_SUBJECT + "']")));

    }

    @AfterClass
    public void exit(){

        driver.findElement(By.xpath("//a[@aria-haspopup='true']/span")).click();
        driver.findElement(By.xpath("//a[@id='gb_71']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.quit();


    }


}
