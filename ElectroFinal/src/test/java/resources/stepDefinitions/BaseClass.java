package resources.stepDefinitions;

import resources.pageObject.AccountDetails;
import resources.pageObject.HomePage;
import resources.pageObject.MyAccount;
import org.openqa.selenium.WebDriver;
import java.security.SecureRandom;


public class BaseClass {
    WebDriver driver;
    HomePage homePage;
    MyAccount myAccount;
    AccountDetails accountDetails;


    String oldPassword;
    String newPassword;



    public static class PasswordGenerator {
        private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_+=<>?";

        public static String generateRandomPassword() {
            int length = 15;
            SecureRandom random = new SecureRandom();
            StringBuilder password = new StringBuilder();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(CHARACTERS.length());
                password.append(CHARACTERS.charAt(index));
            }

            return password.toString();
        }
    }
}
