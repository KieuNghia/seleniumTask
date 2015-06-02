package tests;

import drivers.DriverFactory;
import pageObjects.yandex.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;


import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


public class YandexMailTest {


    private static final String START_URL = "https://mail.yandex.ua/";
    private static final String LOGIN = "testmailbox.test@yandex.ru";
    private static final String PASSWORD = "testmail";
    private static final String DOMAIN = "";

    private static final String LETTER_SUBJECT = "nichego";
    private static final String LETTER_BODY = "onetwo";
    private static final String LETTER_DEST = "mnikto1@yahoo.com";

    private WebDriver driver = null;
    MailPage mailPage = new MailPage(driver);
    LoginPage page = new LoginPage(driver);
    DraftPage draftPage = new DraftPage(driver);
    CreateMailPage createMailPage = new CreateMailPage(driver);


    @BeforeClass(description = "Start browser")
    public void startBrowser() {
        try {
            driver = new DriverFactory().DriverBuilder("firefox");
            driver.get(START_URL);
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

        page.loginInsert(LOGIN).passwordInsert(PASSWORD).clickOk();


    }

    @Test(dependsOnMethods = "login", description = "create letter and save to draft")
    public void createLetter() {

        mailPage
                .createMail()
                .toFieldInsert(LETTER_DEST)
                .subjectFieldInsert(LETTER_SUBJECT)
                .textAreaInsert(LETTER_BODY).saveDraft();


    }

    @Test(dependsOnMethods = "createLetter", description = "check letter in draft ")
    public void checkLetterInDraft() {

        mailPage
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
                .moveToDraft().checkLetterAbsent(LETTER_SUBJECT);


    }


    @Test(dependsOnMethods = "checkLetterAbsentInDraft", description = "check letter in sent folder")
    public void checkLetterInSentFolder() {


        mailPage
                .moveToSent().checkLetterPresent(LETTER_SUBJECT);

    }

    @AfterClass
    public void exit() {
        draftPage.goToMainPage().quit();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.quit();


    }


}
