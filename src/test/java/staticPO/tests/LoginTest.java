package staticPO.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import staticPO.pages.LoginPage;


public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @BeforeClass
    public void beforeClass(){
        loginPage = new LoginPage(driver);
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.manage().deleteAllCookies();
    }

    @Test (priority = 0)
    public void unsuccessfulLoginTest() {
        loginPage.attemptLogin("l.zubtsova@mail.ru", "14031Atc");
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";

        Assert.assertEquals(expectedMessage,loginPage.getMessageError());
    }

    @Test (priority = 1)
    public void successfulLoginTest() {
        loginPage.attemptLogin("l.zubtsova@mail.ru", "14031993Atc");
        String expectedMessage = "You are now logged in as L Z.";

        Assert.assertEquals(expectedMessage,loginPage.getMessageSuccess());
    }

}
