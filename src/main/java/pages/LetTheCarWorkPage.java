package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class LetTheCarWorkPage extends BasePage{

    public LetTheCarWorkPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "pickUpPlace")
    WebElement inputLocation;

    @FindBy(id = "make")
    WebElement inputManufacturer;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;

    Select selectFuel = new Select(driver.findElement(By.id("fuel")));

    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputCarClass;
    @FindBy(id = "serialNumber")
    WebElement inputCarRegistrationNumber;
    @FindBy(id = "price")
    WebElement inputPrice;
    @FindBy(id = "about")
    WebElement inputAbout;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//h1[text()='Car added']")
    WebElement messageCarAdded;

    public LetTheCarWorkPage selectLocation(String location) {
        inputLocation.sendKeys(location);
        pause(3);
        inputLocation.sendKeys(Keys.ARROW_DOWN);
        inputLocation.sendKeys(Keys.ENTER);
        return this;
    }

    public LetTheCarWorkPage fillCarForm(CarDto car) {
        inputManufacturer.sendKeys(car.getManufacturer());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear().toString());
        selectFuel.selectByValue(car.getFuel().getText());
        inputSeats.sendKeys(car.getSeats().toString());
        pause(3);
        inputCarClass.sendKeys(car.getCarClass());
        inputCarRegistrationNumber.sendKeys(car.getCarRegistrationNumber());
        inputPrice.sendKeys(car.getPrice().toString());
        inputAbout.sendKeys(car.getAbout());
        pause(3);
        return this;
    }

    public LetTheCarWorkPage clickSubmitButton() {
        btnSubmit.click();
        return this;
    }

    public boolean isCarAdded() {
        return messageCarAdded.isDisplayed();
    }

}
