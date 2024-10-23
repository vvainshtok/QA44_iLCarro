package pages;

import manager.ApplicationManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static utils.PropertiesReader.getProperty;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        setDriver(driver);
        driver.get(getProperty("data.properties","url"));
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath="//a[text()=' Log in ']")
    WebElement btnLogin;
    @FindBy(xpath="//a[text()=' Sign up ']")
    WebElement btnSignup;
    @FindBy(xpath="//button[text()='Y’alla!']")
    WebElement btnYalla;
    @FindBy(id="city")
    WebElement inputCity;
    @FindBy(id="dates")
    WebElement inputDates;
    @FindBy(xpath="//button[@aria-label='Choose month and year']")
    WebElement btnChooseMonthYear;

    public LoginPage clickBtnLogin() {
        btnLogin .click();
        return new LoginPage(driver);
    }

    public RegistrationPage clickBtnSignup() {
        btnSignup.click();
        return new RegistrationPage(driver);
    }

    public void fillSearchCarFormCalendar(String city, String startDate, String endDate) {
        fillInputCity(city);
        fillInputDateCalendar(startDate, endDate);
        btnYalla.click();
    }

    private void fillInputDateCalendar(String startDate, String endDate) {
        inputDates.click();
        String[] startDateArray = startDate.split(" ");
        String[] endDateArray = endDate.split(" ");
        typeYearMonthDay(startDateArray[2], startDateArray[1], startDateArray[0]); // year month date
        typeYearMonthDay(endDateArray[2], endDateArray[1], endDateArray[0]);
    }

    private void typeYearMonthDay(String year, String month, String day) {
        btnChooseMonthYear.click();
        driver.findElement(By.xpath("//div[contains(text(),'" + year + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + month.toUpperCase() + "')]")).click();
        driver.findElement(By.xpath("//div[contains(text(),'" + day + "')]")).click();
    }

    private void fillInputCity(String city) {
        System.out.println("--> " + ApplicationManager.height);
        inputCity.click();
        inputCity.sendKeys(city);
        Actions actions = new Actions(driver);
        actions.moveToElement(inputCity, 0, 40).pause(3000).click().perform();
        inputCity.click();
    }

    public boolean validateUrlContainsResult() {
        return new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("search/results"));
    }

    public void fillSearchCarFormWithoutCalendar(String city, String startDate, String endDate) {
        fillInputCity(city);
        fillInputDateWithoutCalendar(startDate, endDate);
    }

    private void fillInputDateWithoutCalendar(String startDate, String endDate) {
        //inputDates.click();
        String[] startDateArray = startDate.split(" ");
        String[] endDateArray = endDate.split(" ");
        String dates = monthNameToNumber(startDateArray[1]) + "/" + startDateArray[0] + "/" + startDateArray[2]
                + " - "
                + monthNameToNumber(endDateArray[1]) + "/" + endDateArray[0] + "/" + endDateArray[2];
        inputDates.sendKeys(dates);
        clickWait(btnYalla, 2);
    }

    private String monthNameToNumber(String month) {
        switch (month) {
            case "Jan":
                return "1";
            case "Feb":
                return "2";
            case "Mar":
                return "3";
            case "Apr":
                return "4";
            case "May":
                return "5";
            case "Jun":
                return "6";
            case "Jul":
                return "7";
            case "Aug":
                return "8";
            case "Sep":
                return "9";
            case "Oct":
                return "10";
            case "Nov":
                return "11";
            case "Dec":
                return "12";
            default:
                return null;
        }
    }
}
