package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);//initializes everything that has @FindBy annotation
    }

    @FindBy (id = "ctl00_MainContent_username")
    private WebElement username ;

    @FindBy (name = "ctl00$MainContent$password")
    private WebElement password;

    @FindBy (xpath = "//*[@class='button']")
    private WebElement button;

    public void enterUsername (String username) {
        this.username.sendKeys(username);
    }

    public void enterPassword (String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        button.click();
    }

    public void login() {
        this.username.sendKeys(ConfigReader.getProperty("username"));
        this.password.sendKeys(ConfigReader.getProperty("password"));
        this.button.click();
    }

}
