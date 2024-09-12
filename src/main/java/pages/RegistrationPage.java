package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@id='name']")
    WebElement inputName;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement inputLastName;
    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//input[@type='checkbox']")
            // //label[@for='terms-of-use']
            // //*[text()=' I agree to the ']
            // //*[text()=' and ']
            // //div[@class='checkbox-container']
    WebElement checkboxTermsOfUse;

    @FindBy(xpath = "//form/button")
    WebElement btnYalla;

    @FindBy(xpath = "//*[text()='Registered']")
    WebElement textRegistered;
    @FindBy(xpath = "//button[text()='Ok']")
    WebElement btnOk;

    public RegistrationPage typeRegistrationForm(String name, String lastName, String email, String password) {
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        checkboxTermsOfUse.click();
        return this;
    }

    public RegistrationPage clickBtnRegistrationPositive() {
        btnYalla.click();
        return this;
    }

    public AccountPage clickBtnRegistrationOk() {
        if (textRegistered.isDisplayed())
            btnOk.click();
        return new AccountPage(driver);
    }
}