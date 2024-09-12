package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnSignupHeader()
                .typeRegistrationForm("Victor","V","vv3@gmail.com","QWErty123!")
                .clickBtnRegistrationPositive()
                .clickBtnRegistrationOk()
                .isElementLogoutPresent());

    }
}
