package staticPO.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import staticPO.pages.RubberDucksPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksTest extends BaseTest {
    RubberDucksPage rubberDucksPage;

    @BeforeClass
    public void beforeClass() {
        rubberDucksPage = new RubberDucksPage(driver);
    }

    @Test
    public void numberOfDucks() {
        rubberDucksPage.goToRubberDucks();
        int numberOfDucks = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).size();
        int actualCount = numberOfDucks;
        int expectedCount = 5;
        Assert.assertEquals(actualCount, expectedCount);
    }
    @Test
    public void priceOfTheFirstDuckOnDatePage() {
        rubberDucksPage.goToDatePage();
        SelenideElement price = $(By.xpath("//div[@class='price-wrapper']//*[@class='campaign-price']"));
        String expectedPrice = "$18";
        price.shouldHave(Condition.exactText(expectedPrice));

    }
    @Test
    public void priceOfTheFirstDuckOnNamePage() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.goToNamePage();
        SelenideElement price = $(By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4']//*[@class='price']"));
        String expectedPrice = "$20";
        price.shouldHave(Condition.exactText(expectedPrice));
    }

    @Test
    public void sizeOfDucksCollectionTest() {
        rubberDucksPage.goToRubberDucks();
        ElementsCollection ducks = $$(rubberDucksPage.collection);
        ducks.shouldBe(CollectionCondition.size(5));
    }

    @Test
    public void namesOfDucksTest(){
        rubberDucksPage.goToRubberDucks();
        ElementsCollection ducks = $$(rubberDucksPage.collection);
        ducks.shouldBe(CollectionCondition.containExactTextsCaseSensitive
                ("Purple Duck","Yellow Duck","Green Duck","Red Duck","Blue Duck"));
    }

//
//    @Test
//    public void firstDucsTest(){
//    }
//    @Test
//    public void secondtDucsTest(){
//    }
//    @Test
//    public void thirdDucsTest(){
//    }
//
//    @Test
//    public void forthDucsTest(){
//    }
//
//    @Test
//    public void fifthDucsTest(){
//    }
}
