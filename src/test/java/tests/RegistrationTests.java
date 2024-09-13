package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.Random;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        String email = "vv" + i + "@gmail.com";
         Assert.assertTrue(
                new HomePage(getDriver())
                .clickBtnSignupHeader()
                .typeRegistrationForm("Victor","V",email,"QWErty123!")
                .clickCheckBox()
                .clickBtnYalla()
                .isElementPresentRegSuccess())
         ;

    }
}
