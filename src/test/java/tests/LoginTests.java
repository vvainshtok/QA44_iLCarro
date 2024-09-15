package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {

    @Test
    public void loginPositiveTest() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("vv@gmail.com", "QWErty123!")
                .clickBtnYalla()
                .isTextInElementPresent_LoginSuccess());
    }

    @Test
    public void loginNegativeTest_wrongPassword() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("vv@gmail.com", "QWErty123!_wrong")
                .clickBtnYalla()
                .isTextInElementPresent_errorMessageLogin());
    }
    @Test
    public void loginNegativeTest_wrongEmail() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("vv_wrong@gmail.com", "QWErty123!")
                .clickBtnYalla()
                .isTextInElementPresent_errorMessageLogin());
    }

    @Test
    public void loginNegativeTest_invalidEmail() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("invalidemail", "QWErty123!")
                .isTextInElementPresent_errorMessageNotEmail());
    }

    @Test
    public void loginNegativeTest_emptyEmail() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("", "QWErty123!")
                .isTextInElementPresent_errorMessageEmailRequired());
    }

    @Test
    public void loginNegativeTest_emptyPassword() {
        Assert.assertTrue(new HomePage(getDriver())
                .clickBtnLoginHeader()
                .typeLoginForm("vv@gmail.com", "")
                .isTextInElementPresent_errorMessagePasswordRequired());
    }
}
