package resources.pageObject;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class AccountDetails {
    WebDriver driver;
    Faker faker;

    WaitHelper waitHelper;

    public AccountDetails(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        faker = new Faker();
        waitHelper = new WaitHelper(driver);
    }

    @FindBy(id = "account_first_name")
    @CacheLookup
    WebElement firstNameField;

    @FindBy(id = "account_last_name")
    @CacheLookup
    WebElement lastNameField;

    @FindBy(id = "account_display_name")
    @CacheLookup
    WebElement displayNameField;
    @FindBy(name = "save_account_details")
    @CacheLookup
    WebElement saveBtn;
    @FindBy(id = "password_current")
    @CacheLookup
    WebElement currentPasswordField;
    @FindBy(id = "password_1")
    @CacheLookup
    WebElement newPasswordField;

    @FindBy(id = "password_2")
    @CacheLookup
    WebElement confirmNewPasswordField;

    @FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[7]")
    @CacheLookup
    WebElement logOut;


    public void getRandomName() {
        String fakeName = faker.name().firstName();
        firstNameField.clear();
        firstNameField.sendKeys(fakeName);
    }

    public void getRandomLastName() {
        String fakeLastName = faker.name().lastName();
        lastNameField.clear();
        lastNameField.sendKeys(fakeLastName);
    }

    public void randomDisplayName() {
        String fakeDisplayName = faker.lordOfTheRings().character();
        displayNameField.clear();
        displayNameField.sendKeys(fakeDisplayName);
    }

    public void saveChanges() {
        waitHelper.WaitForElement(saveBtn, 10);
        saveBtn.sendKeys(Keys.ENTER);
    }

    public void setCurrentPasswordField(String str) {
        currentPasswordField.sendKeys(str);
    }

    public void setNewPasswordField(String str) {
        newPasswordField.sendKeys(str);
    }

    public void setConfirmNewPasswordField(String str) {
        confirmNewPasswordField.sendKeys(str);
    }

    public void logOut() {
        logOut.click();
    }
}

