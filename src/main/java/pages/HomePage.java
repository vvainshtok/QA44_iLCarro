package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath="//a[text()=' Log in ']")
    WebElement btnLogin;
    @FindBy(xpath="//a[text()=' Sign up ']")
    WebElement btnSignup;

    public LoginPage clickBtnLogin() {
        btnLogin .click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickBtnSignup() {
        btnSignup.click();
        return new RegistrationPage(driver);
    }


}
