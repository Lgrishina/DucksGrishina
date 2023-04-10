package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class RubberDucksPage extends BasePage {

    private static final By rubberDucks = By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    private static final By buttonData =  By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=date']");

    private static final By buttonName = By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void goToRubberDucks() {
        driver.findElement(rubberDucks).click();
    }

    public  void goToDatePage() {
        driver.findElement(buttonData).click();
    }

    public void goToNamePage() {
        driver.findElement(buttonName).click();
    }

}
