package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import utils.HeaderMenuItem;

import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.generateString;

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest() {
        int i = new Random().nextInt(1000);
        String email = "vv" + i + "@gmail.com";
         Assert.assertTrue(
                new HomePage(getDriver())
                .clickBtnSignup()
                .typeRegistrationForm("Victor","V",email,"QWErty123!")
                .clickCheckBox()
                .clickBtnYalla()
                .isElementPresentRegSuccess())
         ;

    }

    @Test
    public void registrationNegativeTest_invalidEmail() {
        UserDto user = new UserDto(generateString(5),generateString(7),
                generateString(10), "QWErty123!");
        new HomePage(getDriver());
        RegistrationPage registrationPage = clickButtonsOnHeader(HeaderMenuItem.SIGN_UP);
        Assert.assertTrue(registrationPage.typeRegistrationForm(user)
                .isTextInElementPresent_ErrorEmail("Wrong email format"));
    }

}
