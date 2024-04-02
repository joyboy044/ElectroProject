package resources.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccount {
    WebDriver driver;


    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "username")
    @CacheLookup
    WebElement usernameField;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordField;

    @FindBy(xpath = "//button[@name='login']")
    @CacheLookup
    WebElement logInBtn;

    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[6]")
    @CacheLookup
    WebElement accountDetailsTab;

    @FindBy(xpath = "//h1[@class='entry-title']")
    @CacheLookup
    WebElement dashboardTab;


    public void goToAccountDetails() {
        accountDetailsTab.click();
    }

    public void setUser(String user) {
        usernameField.sendKeys(user);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnLogin() {
        logInBtn.click();
    }

    public String getDashboardText() {
        return dashboardTab.getText();
    }
}


