package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.HeaderMenuItem;

public class BasePage {

    static WebDriver driver;

    public static void setDriver(WebDriver wd) {
        driver = wd;
    }

    public void pause(int time) {
        try {
            Thread.sleep(1000L*time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isTextInElementPresent(WebElement element, String text) {
        return element.getText().contains(text);
    }

    public static <T extends BasePage> T clickButtonsOnHeader(HeaderMenuItem headerMenuItem) {

        WebElement element = driver.findElement(By.xpath(headerMenuItem.getLocator()));
        element.click();
        switch (headerMenuItem) {
            case LOG_IN:
                return (T) new LoginPage(driver);
            case SIGN_UP:
                return (T) new RegistrationPage(driver);
            case SEARCH:
                return (T) new HomePage(driver);
            case TERMS_OF_USE:
                return (T) new TermsOfUsePage(driver);
            case LET_THE_CAR_WORK:
                return (T) new LetTheCarWorkPage(driver);
            default:
                throw new IllegalArgumentException("Invalid parameter headerMenuItem");
        }
    }


}
