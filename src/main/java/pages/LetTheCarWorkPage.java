package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "//h1[text()='Car added']")
    WebElement messageCarAdded;

    /*
    public LetTheCarWorkPage selectLocation(String location) {

    // WebElement inputLocationW = new WebDriverWait(driver, Duration.ofSeconds(10))
    //        .until(ExpectedConditions.elementToBeClickable(By.id("pickUpPlace")));
        inputLocation.sendKeys(location);
        pause(3);
        inputLocation.sendKeys(Keys.ARROW_DOWN);
        inputLocation.sendKeys(Keys.ENTER);
        return this;
    }
    */

    public LetTheCarWorkPage typeAddNewCarForm(CarDto car) {
        inputLocation.sendKeys(car.getCity());
        pause(2);
        driver.findElement(By.xpath("//div[@class='pac-item']")).click();

/*
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear().toString());
        selectFuel.selectByValue(car.getFuel().getText());
        inputSeats.sendKeys(car.getSeats().toString());
        pause(3);
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(car.getPricePerDay().toString());
        inputAbout.sendKeys(car.getAbout());
        pause(3);
  */
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
