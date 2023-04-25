package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LoginPage1;
import utils.ConfigReader;
import utils.Driver;

public class LoginTest extends TestBase {

    @Test (groups = {"smoke"})
    public void pasitiveLogin() {


        LoginPage1 loginPage = new LoginPage1();
        loginPage.enterUsername (ConfigReader. getProperty ("username"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void positiveLoginBadStyle() {

        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"));
        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
        Driver.getDriver().findElement(By.className("button")).click();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Web Orders");
    }

    @Test (groups = {"smoke"})
    public void negativeLogin() {


        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername ("dsds");
        loginPage.enterPassword("dssd");
        loginPage.clickLoginButton();
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void negativeLogin2() {


        LoginPage1 loginPage = new LoginPage1();
        loginPage.enterUsername ("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

}