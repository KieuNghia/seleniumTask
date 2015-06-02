package tests;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.gmail.CreateMailPage;
import pageObjects.gmail.DraftPage;
import pageObjects.gmail.LoginPage;
import pageObjects.gmail.MailPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class GmailTest {


    private static final String START_URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl";
    private static final String LOGIN = "petrov.vas123321123@gmail.com";
    private static final String PASSWORD = "123an123";
    private static final String DOMAIN = "";

    private static final String LETTER_SUBJECT = "nichego";
    private static final String LETTER_BODY = "onetwo";
    private static final String LETTER_DEST = "nghia_hiep04@yahoo.com";
    private static final String ACCOUNT_BUTTON = "";

    private WebDriver driver = null;
    private LoginPage loginPage;

    MailPage mailPage = new MailPage(driver);
    DraftPage draftPage = new DraftPage(driver);
    CreateMailPage createMailPage = new CreateMailPage(driver);


    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        try {
            driver = new DriverFactory().DriverBuilder("firefox");
            driver.get(START_URL);
            loginPage = new LoginPage(driver);

        } catch (MalformedURLException e) {

            e.printStackTrace();
        }
    }

    @BeforeClass(dependsOnMethods = "startBrowser", description = "Add implicitly")
    public void addImplicitly() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test(description = "login to mail")
    public void login() {

        loginPage
                .loginInsert(LOGIN)
                .passwordInsert(PASSWORD)
                .clickOk();


    }

    @Test(dependsOnMethods = "login", description = "create letter and save in draft")
    public void createLetter() {

        mailPage
                .createMail()
                .toFieldInsert(LETTER_DEST)
                .subjectFieldInsert(LETTER_SUBJECT)
                .textAreaInsert(LETTER_BODY)
                .saveDraft();


    }

    @Test(dependsOnMethods = "createLetter", description = "check letter in draft ")
    public void checkLetterInDraft() {

        mailPage
                .moveToDraft()
                .checkLetterPresent(LETTER_SUBJECT)
                .goToLetter(LETTER_SUBJECT);


    }

    @Test(dependsOnMethods = "checkLetterInDraft", description = "send letter in draft")
    public void sendLetter() {

        createMailPage
                .sendLetter();


    }

    @Test(dependsOnMethods = "sendLetter", description = "check letter in draft")
    public void checkLetterAbsentInDraft() {

        mailPage
                .moveToDraft()
                .checkLetterAbsent(LETTER_SUBJECT);


    }


    @Test(dependsOnMethods = "checkLetterAbsentInDraft", description = "check letter in sent folder")
    public void checkLetterInSentFolder() {


        mailPage
                .moveToSent()
                .checkLetterPresent(LETTER_SUBJECT);

    }

    @AfterClass
    public void exit() {

        driver.findElement(By.xpath("//a[@aria-haspopup='true']/span")).click();
        driver.findElement(By.xpath("//a[@id='gb_71']")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.quit();


    }


}
