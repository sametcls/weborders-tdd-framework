package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllOrdersPage;
import pages.LoginPage1;
import utils.ConfigReader;

public class OrdersTest extends TestBase {

    @Test (groups = {"smoke"})
    public void deleteSelectedButtonTest(){

//        Driver.getDriver().findElement(By.name("ctl00$MainContent$username")).sendKeys(ConfigReader.getProperty("username"));
//        Driver.getDriver().findElement(By.name("ctl00$MainContent$password")).sendKeys(ConfigReader.getProperty("password"));
//        Driver.getDriver().findElement (By.className ("button")).click();
//        Assert.assertEquals(Driver.getDriver().getTitle (), "Web Orders");
//        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
//        Driver.getDriver().findElement (By.name("ctl00$MainContent$btnDelete")).click();
//        Assert.assertTrue(Driver.getDriver().getPageSource().contains("List of orders is empty."));


        LoginPage1 loginPage = new LoginPage1();
        loginPage.enterUsername (ConfigReader. getProperty ("username" ));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
        loginPage.clickLoginButton();

        AllOrdersPage allOrdersPage = new AllOrdersPage () ;
        allOrdersPage.clickCheckAll();
        allOrdersPage.clickDeleteSelected();



        Assert.assertTrue(allOrdersPage.getMessage().isDisplayed());

    }

}
