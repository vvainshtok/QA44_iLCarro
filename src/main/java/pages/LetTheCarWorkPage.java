package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;


public class LetTheCarWorkPage extends BasePage{

    public LetTheCarWorkPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "pickUpPlace")
    WebElement inputLocation;
    @FindBy(id = "make")
    WebElement inputManufacture;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement inputFuel;

    // Select selectFuel = new Select(driver.findElement(By.id("fuel")));

    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputCarClass;
    @FindBy(id = "serialNumber")
    WebElement inputSerialNumber;
    @FindBy(id = "price")
    WebElement inputPrice;
    @FindBy(id = "about")
    WebElement inputAbout;
    @FindBy(id = "photos")
    WebElement inputPhoto;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//div[@class='dialog-container']/h2")
    // @FindBy(xpath = "//h1[text()='Car added']")
    WebElement messageCarAdded;

    @FindBy(xpath = "//*[@id = 'pickUpPlace']/following-sibling::*")
    WebElement errorMessageLocation;
    @FindBy(xpath = "//*[@id = 'make']/following-sibling::*")
    WebElement errorMessageManufacture;
    @FindBy(xpath = "//*[@id = 'model']/following-sibling::*")
    WebElement errorMessageModel;
    @FindBy(xpath = "//*[@id = 'year']/following-sibling::*/div")
    WebElement errorMessageYear;
    @FindBy(xpath = "//*[@id = 'seats']/following-sibling::*/div")
    WebElement errorMessageSeats;
    @FindBy(xpath = "//*[@id = 'class']/following-sibling::*")
    WebElement errorMessageCarClass;
    @FindBy(xpath = "//*[@id = 'serialNumber']/following-sibling::*/div")
    WebElement errorMessageSerialNumber;
    @FindBy(xpath = "//*[@id = 'price']/following-sibling::*/div")
    WebElement errorMessagePrice;

    public LetTheCarWorkPage typeAddNewCarForm(CarDto car)  {
        inputLocation.sendKeys(car.getCity());
        // pause(2);
        // driver.findElement(By.xpath("//div[@class='pac-item']")).click();
        clickWait(By.xpath("//div[@class='pac-item']"), 3);
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());

        inputFuel.click();
        clickWait(By.xpath(car.getFuel()), 3);
        //inputFuel.sendKeys(car.getFuel());
        //selectFuel.selectByValue(car.getFuel().getLocator());
        if (car.getSeats() == -999) inputSeats.sendKeys("");
            else inputSeats.sendKeys(car.getSeats()+"");
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        if (car.getPricePerDay() == -999.0) inputPrice.sendKeys("");
            else inputPrice.sendKeys(Double.toString(car.getPricePerDay()));
        inputAbout.sendKeys(car.getAbout());
        File file = new File("src/test/resources/" + car.getImage());
        inputPhoto.sendKeys(file.getAbsolutePath());

        return this;
    }

    public LetTheCarWorkPage clickBtnSubmit() {
        clickWait(btnSubmit, 3);
        // btnSubmit.click();
        return this;
    }

    public boolean isCarAdded() {
        return messageCarAdded.isDisplayed();
    }

    public boolean validatePopUpMessage(String text) {
        return isTextInElementPresent(messageCarAdded, text);
    }

    public boolean isBtnSubmitClickable() {
        return isElementClickable(btnSubmit, 3);
    }

    public boolean isMessageWrongLocationPresent() {
        return isTextInElementPresent(errorMessageLocation, "Wrong address");
    }

    public boolean isMessageLessThan2SeatsPresent() {
        return isTextInElementPresent(errorMessageSeats, "Car must have min 2 seat");
    }

    public boolean isMessageMoreThan20SeatsPresent() {
        return isTextInElementPresent(errorMessageSeats, "To much seats");
    }

    public boolean isMessageEmptyManufacturePresent() {
        return isTextInElementPresent(errorMessageManufacture, "Make is required");
    }

    public boolean isMessageEmptyModelPresent() {
        return isTextInElementPresent(errorMessageModel, "Model is required");
    }

    public boolean isMessageEmptyYearPresent() {
        return isTextInElementPresent(errorMessageYear, "Year required");
    }

    public boolean isMessageWrongYearPresent() {
        return isTextInElementPresent(errorMessageYear, "Wrong year");
    }

    public boolean isMessageEmptySeatsPresent() {
        return isTextInElementPresent(errorMessageSeats, "Number of seats is required");
    }

    public boolean isMessageEmptyCarClassPresent() {
        return isTextInElementPresent(errorMessageCarClass, "Car class is required");
    }

    public boolean isMessageEmptySerialNumberPresent() {
        return isTextInElementPresent(errorMessageSerialNumber, "Car registration number is required");
    }

    public boolean isMessageTooLongSerialNumberPresent() {
        return isTextInElementPresent(errorMessageSerialNumber, "To long car registration number");
    }

    public boolean isMessageEmptyPricePresent() {
        return isTextInElementPresent(errorMessagePrice, "Price is required");
    }

    public boolean isMessagePriceLessThan0Present() {
        return isTextInElementPresent(errorMessagePrice, "Price must be positive");
    }

    public boolean isMessagePriceMoreThan1000Present() {
        return isTextInElementPresent(errorMessagePrice, "To much big price");
    }
}
