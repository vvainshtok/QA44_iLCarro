package tests;

import dto.CarDto;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import pages.LoginPage;
import utils.*;

import static pages.BasePage.clickButtonsOnHeader;
import static utils.RandomUtils.*;

public class AddCarTests extends ApplicationManager {

    UserDto user = new UserDto("Victor", "V","vv@gmail.com","QWErty123!");
    LetTheCarWorkPage letTheCarWorkPage;

   @BeforeMethod
    public void login() {
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
        loginPage.typeLoginForm(user).clickBtnYalla();
        letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }

    @Test
    public void addCarPositiveTest() {

       String location = "Tel Aviv";
       String carManufacturerAndModel[] = generateManufacturerAndModel();
       CarDto car = CarDto.builder()
                .manufacturer(carManufacturerAndModel[0])
                .model(carManufacturerAndModel[1])
                .year(2000+generateNumber(25))
                .fuel(generateFuelType())
                .seats(4+generateNumber(4))
                .carClass(generateString(6))
                .carRegistrationNumber(generateNumber(100000000).toString())
                .price(generateNumber(300))
                .about(generateString(30))
                .build();

        Assert.assertTrue(letTheCarWorkPage.selectLocation(location)
                .fillCarForm(car)
                .clickSubmitButton()
                .isCarAdded());
    }
}
