package resources.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import resources.pageObject.AccountDetails;
import resources.pageObject.HomePage;
import resources.pageObject.MyAccount;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class Steps extends BaseClass {

    //Login features
    @Given("the user launch browser")
    public void theUserLaunchBrowser() {
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }

    @When("user opens URL {string}")
    public void userOpensUrl(String url) {
        driver.get(url);
    }

    @When("user clicks on My Account")
    public void userClicksOnMyAccount() {
        homePage.clickOnMyAccount();
        myAccount = new MyAccount(driver);
    }

    @When("clicks on Log in button")
    public void clicksOnLogInButton() {
        myAccount.clickOnLogin();
    }

    @Then("the user should be on dashboard")
    public void theUserShouldBeOnDashboard() {
        Assert.assertEquals("My Account", myAccount.getDashboardText());
    }

    @Then("close browser")
    public void closeBrowser() {
        driver.quit();
    }


    //ChangeAccountFeatures

    @Then("click on Account Details")
    public void clickOnAccountDetails() {
        myAccount.goToAccountDetails();
        accountDetails = new AccountDetails(driver);
    }

    @When("system generates random First, Last and Display name")
    public void systemGeneratesRandomFirstLastAndDisplayName() {
        accountDetails.getRandomName();
        accountDetails.getRandomLastName();
        accountDetails.randomDisplayName();
    }

    @When("user clicks on Save changes")
    public void userClicksOnSaveChanges() {
        accountDetails.saveChanges();

    }

    @Then("user should receive message {string}")
    public void userShouldReceiveMessage(String string) {
        Assert.assertEquals(string, driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText());
    }


    //Change password feature
    @When("user enters username as {string} and last password changed")
    public void userEntersUsernameAsAndPreviouslyRandomGeneratedPassword(String uname) throws IOException {
        myAccount.setUser(uname);
        this.oldPassword = new String(Files.readAllBytes(Paths.get("password.txt")));
        myAccount.setPassword(oldPassword);


    }

    @When("system enters last password changed")
    public void systemEntersPreviouslyGeneratedPassword() throws IOException {
        accountDetails.setCurrentPasswordField(oldPassword);
        this.newPassword = PasswordGenerator.generateRandomPassword();
        Files.write(Paths.get("password.txt"), newPassword.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }

    @When("generates new password")
    public void generatesNewPassword() {
        accountDetails.setNewPasswordField(newPassword);
        accountDetails.setConfirmNewPasswordField(newPassword);
    }

    @When("user re enters username and new created password")
    public void userReEntersUsernameAndNewCreatedPassword() {
        myAccount = new MyAccount(driver);
        myAccount.setUser("ChangePasswordAutomation");
        myAccount.setPassword(newPassword);
    }

    @Then("user clicks on log out button")
    public void userClicksOnLogOutButton() {
        accountDetails.logOut();
    }

}