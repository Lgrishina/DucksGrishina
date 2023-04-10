package staticPO.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    protected WebDriver driver;
    protected String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeTest
    protected void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

    @BeforeMethod
    protected void setupBefore() {
        open(baseUrl);
    }


    @AfterTest
    protected void teardown() {
        driver.quit();
    }
}
