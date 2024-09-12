package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.nio.file.WatchEvent;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get("https://ilcarro.web.app/search");
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath="//app-navigator/div/a[text()=' Log in ']")
    WebElement btnLoginHeader;
    @FindBy(xpath="//app-navigator/div/a[text()=' Sign up ']")
    WebElement btnSignupHeader;

    public LoginPage clickBtnLoginHeader() {
        btnLoginHeader.click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickBtnSignupHeader() {
        btnSignupHeader.click();
        return new RegistrationPage(driver);
    }


}
