package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchCarTests extends ApplicationManager {

    HomePage homePage;

    @Description("positive method search car")
    @Owner("QA Victor")
    @Test
    public void searchCarPositiveTest() {
        Allure.step("fill search car form");
        homePage = new HomePage(getDriver());
        homePage.fillSearchCarFormCalendar("Tel Aviv", "17 Dec 2024", "8 Jan 2025");
        Assert.assertTrue(homePage.validateUrlContainsResult());
    }

    @Test
    public void searchCarPositiveTestWithoutCalendar() {
        homePage = new HomePage(getDriver());
        homePage.fillSearchCarFormWithoutCalendar("Tel Aviv", "17 Dec 2024", "8 Jan 2025");
        Assert.assertTrue(homePage.validateUrlContainsResult());
    }

    @Description("negative method search car")
    @Owner("QA not Victor")
    @Test(expectedExceptions = {org.openqa.selenium.NoSuchElementException.class})
    public void searchCarNegativeTest_wrongDate() {
        Allure.step("fill search car form");
        homePage = new HomePage(getDriver());
        Allure.step("create home page");
        homePage.fillSearchCarFormCalendar("Tel Aviv", "17 Oct 2023", "8 Aug 2025");
    }
}
