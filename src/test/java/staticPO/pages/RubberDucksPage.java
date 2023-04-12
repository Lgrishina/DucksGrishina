package staticPO.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksPage extends BasePage {

    private static final By rubberDucks = By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    private static final By buttonData =  By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/subcategory-c-2/yellow-duck-p-1']");

    private static final By buttonName = By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");


    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public void goToRubberDucks() {
        driver.findElement(rubberDucks).click();
        $(rubberDucks).click();
    }

    public  void goToDatePage() {
       $(buttonData).click();
    }

    public void goToNamePage() {
        $(buttonName).click();
    }

}


//    ElementsCollection collect = $$(successMessage);
//
//collect.shouldBe(CollectionCondition.containExactTextsCaseSensitive("ff", "dd"));
//        collect.shouldBe(CollectionCondition.);