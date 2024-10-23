package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;



public class ApplicationManager     {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public static int height;
    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    @BeforeMethod
    public void setUp() {
        logger.info("Start method --> setUp" );
        driver = new ChromeDriver();
        WebDriverListener webDriverListener = new WDListener();
        driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);
        driver.manage().window().maximize();
        height = driver.manage().window().getSize().height;
    }

    @AfterMethod
    public void tearDown() {
        logger.info("Start method --> tearDown" );
        //if(driver != null) {
        //   driver.quit();
        //}
    }

 }
