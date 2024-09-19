package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;

import static utils.RandomUtils.*;
import static pages.BasePage.clickButtonsOnHeader;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeLoginForm("vv@gmail.com", "QWErty123!")
                .clickBtnYalla()
                .isTextInElementPresent_Login("Logged in success"));
    }

    // тесты, написанные на уроке вместе с Алексеем
    @Test
    public void loginNegativeTest_invalidEmailWOAt() {
        UserDto user = new UserDto(generateString(5),generateString(7),
                generateString(10), "QWErty123!");
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLogin()
                .typeLoginForm(user)
                .isTextInElementPresent_ErrorEmail("not look like email"));
    }
    @Test
    public void loginNegativeTest_invalidEmailWOAt_Enum() {
    UserDto user = new UserDto(generateString(5),generateString(7),
                generateString(10), "QWErty123!");
    new HomePage(getDriver());
    LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
    Assert.assertTrue(loginPage.typeLoginForm(user)
            .isTextInElementPresent_ErrorEmail("not look like email"));
    }

    // тесты, написанные дома 12.09.24 (подправил 19.09.24)
    @Test
    public void loginNegativeTest_emptyPassword() {
        UserDto user = new UserDto(generateString(5),generateString(7),
                "vv@gmail.com", "");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
        Assert.assertTrue(loginPage.typeLoginForm(user)
                .isTextInElementPresent_ErrorPassword("Password is required"));
    }
    @Test
    public void loginNegativeTest_emptyEmail() {
        UserDto user = new UserDto(generateString(5),generateString(7),
                "", "QWErty123!");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
        Assert.assertTrue(loginPage.typeLoginForm(user)
                .isTextInElementPresent_ErrorEmail("Email is required"));
    }
    @Test
    public void loginNegativeTest_wrongEmail() {
        UserDto user = new UserDto(generateString(5),generateString(7),
                generateEmail(10), "QWErty123!");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
        Assert.assertTrue(loginPage.typeLoginForm(user)
                .clickBtnYalla()
                .isTextInElementPresent_Login("Login or Password incorrect"));
    }
    @Test
    public void loginNegativeTest_wrongPassword() {
        UserDto user = new UserDto(generateString(5),generateString(7),
                generateEmail(10), "QWErty123!");
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
        Assert.assertTrue(loginPage.typeLoginForm(user)
                .clickBtnYalla()
                .isTextInElementPresent_Login("Login or Password incorrect"));
    }


}
