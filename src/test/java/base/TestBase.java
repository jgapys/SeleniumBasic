package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.Level;

public class TestBase {
    public WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        logger.info("New ChromeDriver initialization");
        driver.manage().window().maximize();
        logger.info("Maximize browser windows");
    }

    @AfterEach
    void tearDown() {
        try {
            driver.quit();
            logger.info("Driver process completed successfully");
        } catch (Exception ex) {
            logger.error("Error occurred: {}", ex);
        }
    }
}