package pages;

import dto.UserDto;
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
    WebElement textPopUpLogin;

    @FindBy(xpath="//*[@id='email']/..//div[@class='error']/div")
    WebElement errorMessageUnderEmailInput;
    @FindBy(xpath="//*[@id='password']/..//div[@class='error']")
    WebElement errorMessageUnderPasswordInput;


    public LoginPage typeLoginForm(String email, String password) {
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        inputEmail.click();
        return this;
    }

    public LoginPage typeLoginForm(UserDto user) {
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        inputEmail.click();
        return this;
    }

    public LoginPage clickBtnYalla() {
        clickWait(btnYalla, 3);
        // pause(3);
        // btnYalla.click();
        return this;
    }

    public boolean isTextInElementPresent_Login(String text) {
        return isTextInElementPresent(textPopUpLogin, text);
    }


    public boolean isTextInElementPresent_ErrorEmail(String text) {
        return isTextInElementPresent(errorMessageUnderEmailInput, text);
    }
    public boolean isTextInElementPresent_ErrorPassword(String text) {
        return isTextInElementPresent(errorMessageUnderPasswordInput, text);
    }

    public boolean isTextInElementPresent_errorMessageNotEmail() {
        return isTextInElementPresent(errorMessageUnderEmailInput, "not look like email");
    }


}
