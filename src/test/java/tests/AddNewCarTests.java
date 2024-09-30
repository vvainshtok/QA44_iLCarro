package tests;

import data_provider.DPAddCar;
import dto.CarDto;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.LetTheCarWorkPage;
import utils.*;

import java.lang.reflect.Method;
import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {

    UserDto user = new UserDto("Victor", "V","vv@gmail.com","QWErty123!");
    LetTheCarWorkPage letTheCarWorkPage;

    @BeforeMethod
    public void startAddCar() {
        logger.info("Start method --> startAddCar" + " user: " + user.getEmail());
        new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOG_IN);
        loginPage.typeLoginForm(user)
                .clickBtnYalla();
        letTheCarWorkPage = clickButtonsOnHeader(HeaderMenuItem.LET_THE_CAR_WORK);
    }

    @Test
    public void addNewCarPositiveTest(Method method) {
       // String carManufacturerAndModel[] = generateManufacturerAndModel();
       CarDto car = CarDto.builder()
               .city("Haifa")
               .manufacture("Toyota")
               .model("Prius")
                //.manufacture(carManufacturerAndModel[0])
                //.model(carManufacturerAndModel[1])
               .year("2019")
               .fuel(Fuel.DIESEL.getLocator())
                //.fuel(generateFuelType())
               .seats(5)
               .carClass("C-class")
               .serialNumber("1000-" + new Random().nextInt(1000))
               .pricePerDay(1000.0)
               .image("20220205_230058.jpg")
               .about("text")
               .build();
         logger.info("start -->" + method.getName()+ " with data" + car.toString());

         Assert.assertTrue(letTheCarWorkPage
                .typeAddNewCarForm(car)
                .clickBtnSubmit()
                .validatePopUpMessage(car.getManufacture()+" "+car.getModel()+" "));
    }
    // ==================================================================================
    @Test
    public void addNewCarNegativeTest_wrongLocation(Method method) {
        CarDto car = CarDto.builder()
                .city("Qqwweerr")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageWrongLocationPresent());
    }

    @Test
    public void addNewCarNegativeTest_emptyManufacture(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageEmptyManufacturePresent());
    }

    @Test
    public void addNewCarNegativeTest_emptyModel(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageEmptyModelPresent());
    }

    @Test
    public void addNewCarNegativeTest_emptyYear(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageEmptyYearPresent());
    }

    @Test
    public void addNewCarNegativeTest_wrongYear(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("-1")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                .isMessageWrongYearPresent());
    }

    @Test
    public void addNewCarNegativeTest_emptySeats(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(-999)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageEmptySeatsPresent());
    }

    @Test
    public void addNewCarNegativeTest_lessThan2Seats(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(1)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageLessThan2SeatsPresent());
    }

    @Test
    public void addNewCarNegativeTest_moreThan20Seats(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(21)
                .carClass("C-class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageMoreThan20SeatsPresent());
    }

    @Test
    public void addNewCarNegativeTest_carExists(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("0")
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName()+ "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .clickBtnSubmit()
                        .validatePopUpMessage("Car with serial number " +
                                car.getSerialNumber() + " already exists"));
    }

    @Test
    public void addNewCarNegativeTest_emptyCarClass(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName() + "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                        .isMessageEmptyCarClassPresent());
    }

    @Test
    public void addNewCarNegativeTest_emptySerialNumber(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-Class")
                .serialNumber("")
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName() + "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                .isMessageEmptySerialNumberPresent());
    }

    @Test
    public void addNewCarNegativeTest_tooLongSerialNumber(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-Class")
                .serialNumber("1234567890123456")
                .pricePerDay(1000.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName() + "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                .isMessageTooLongSerialNumberPresent());
    }

    @Test
    public void addNewCarNegativeTest_emptyPrice(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-Class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(-999.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName() + "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                .isMessageEmptyPricePresent());
    }

    @Test
    public void addNewCarNegativeTest_lessThan0Price(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-Class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(-1.0)
                .image("20220205_230058.jpg")
                .about("text")
                .build();
        logger.info("start -->" + method.getName() + "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                .isMessagePriceLessThan0Present());
    }

    @Test
    public void addNewCarNegativeTest_moreThan1000Price(Method method) {
        CarDto car = CarDto.builder()
                .city("Haifa")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-Class")
                .serialNumber("1000-" + new Random().nextInt(1000))
                .pricePerDay(1000.1)
                .about("text")
                .image("20220205_230058.jpg")
                .build();
        logger.info("start -->" + method.getName() + "with data" + car.toString());

        Assert.assertTrue(letTheCarWorkPage.typeAddNewCarForm(car)
                .isMessagePriceMoreThan1000Present());
    }

    @Test(dataProvider = "addNewCarDPFile_EmptyOrWrongFields", dataProviderClass = DPAddCar.class)
    public void addNewCarNegativeTest_emptyOrWrongFieldsDP(CarDto car) {
        Assert.assertFalse(
                letTheCarWorkPage.typeAddNewCarForm(car)
                .isBtnSubmitClickable()
        )
        ;
    }
}
