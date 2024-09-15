package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "name")
    WebElement inputName;
    @FindBy(id = "lastName")
    WebElement inputLastName;
    @FindBy(id = "email")
    WebElement inputEmail;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(xpath = "//label[@for='terms-of-use']")
            // //label[@for='terms-of-use']
            // //*[text()=' I agree to the ']
            // //*[text()=' and ']
            // //div[@class='checkbox-container']
            // //input[@type='checkbox']
    WebElement checkbox;

    @FindBy(xpath="//button[@type='submit']")
    WebElement btnYalla;

    @FindBy(xpath="//h2[@class='message']")
    WebElement textPopUpRegSuccess;

    @FindBy(xpath = "//*[text()='Registered']")
    WebElement textRegistered;
    @FindBy(xpath = "//button[text()='Ok']")
    WebElement btnOk;

    public RegistrationPage typeRegistrationForm(String name, String lastName, String email, String password) {
        inputName.sendKeys(name);
        inputLastName.sendKeys(lastName);
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);

    //    inputPassword.sendKeys(Keys.TAB);
    //    new Actions(driver)
    //            .keyDown(Keys.SPACE)
    //            .keyUp(Keys.SPACE)
    //            .perform();
        return this;
    }

    public RegistrationPage clickCheckBox() {
        int width = checkbox.getRect().getWidth();
        int height = checkbox.getRect().getHeight();
        Actions actions = new Actions(driver);
        actions.moveToElement(checkbox,-width/4,-height/4).click().perform();
        return this;
    }

    public RegistrationPage clickBtnYalla() {
        btnYalla.click();
        return this;
    }

    public boolean isElementPresentRegSuccess() {
        return isTextInElementPresent(textPopUpRegSuccess,"You are logged in success");
    }


}