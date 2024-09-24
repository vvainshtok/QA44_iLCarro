package tests;

import dto.CarDto;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import utils.*;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {

    // UserDto user = new UserDto("Victor", "V","vv@gmail.com","QWErty123!");
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod
    public void start() {
        new HomePage(getDriver());
    //    LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
    //    loginPage.typeLoginForm(user).clickBtnYalla();
        letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest() {

       // String location = "Tel Aviv";
       // String carManufacturerAndModel[] = generateManufacturerAndModel();

       CarDto car = CarDto.builder()
               .city("Haifa")
               .manufacture("Toyota")
               .model("Prius")
               .year("2019")
               .fuel("")
               .seats(5)
               .carClass("C-class")
               .serialNumber("1222")
               .pricePerDay(1000)
               .about("text")

/*              .manufacture(carManufacturerAndModel[0])
                .model(carManufacturerAndModel[1])
                .year(2000+generateNumber(25))
                .fuel(generateFuelType())
                .seats(4+generateNumber(4))
                .carClass(generateString(6))
                .serialNumber(generateNumber(100000000).toString())
                .pricePerDay(generateNumber(300))
                .about(generateString(30))
  */
               .build();

               letTheCarWorkPage.typeAddNewCarForm(car);

        // Assert.assertTrue(letTheCarWorkPage.selectLocation(location)
        //        .fillCarForm(car)
        //        .clickSubmitButton()
        //        .isCarAdded());
    }
}
