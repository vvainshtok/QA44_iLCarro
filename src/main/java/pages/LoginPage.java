package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id="email")
    WebElement inputEmail;
    @FindBy(id="password")
    WebElement inputPassword;
    @FindBy(xpath="//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath="//h2[@class='message']")
    WebElement textPopUpLoginSuccess;

    @FindBy(xpath="//*[@id='email']/../div/div")
    WebElement errorMessageUnderEmailInput;
    @FindBy(xpath="//*[@id='password']/../div")
    WebElement errorMessageUnderPasswordInput;


    public LoginPage typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputEmail.click();
        return this;
    }

    public LoginPage clickBtnYalla() {
        pause(3);
        btnYalla.click();
        return this;
    }

    public boolean isTextInElementPresent_LoginSuccess() {
        return isTextInElementPresent(textPopUpLoginSuccess, "Logged in success");
    }

    public boolean isTextInElementPresent_errorMessageLogin() {
        return isTextInElementPresent(textPopUpLoginSuccess, "Login or Password incorrect");
    }

    public boolean isTextInElementPresent_errorMessageNotEmail() {
        return isTextInElementPresent(errorMessageUnderEmailInput, "not look like email");
    }

    public boolean isTextInElementPresent_errorMessageEmailRequired() {
        return isTextInElementPresent(errorMessageUnderEmailInput, "Email is required");
    }

    public boolean isTextInElementPresent_errorMessagePasswordRequired() {
        return isTextInElementPresent(errorMessageUnderPasswordInput, "Password is required");
    }
}
