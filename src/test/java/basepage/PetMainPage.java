package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PetMainPage {
    WebDriver driver;
    WebDriverWait wait;


    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public PetMainPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(id = "js-search")
    WebElement searchButton;

    @FindBy(xpath = "//label[@class='search-field p2']")
    WebElement searchInput;
    @FindBy(xpath = "//div[@class='search-results-items-offer__desc']/a[@href='https://garfield.by/catalog/cats/suhie-korma-dlya-koshek/hills-niderlandyi/hills-science-plan-feline-adult-hairball-control-chicken-kuritsa.html?offer_id=235344']")
    WebElement foodPict;

    @FindBy(id="bx_117848907_194191_add_basket_link")
    WebElement orderButton;

    @FindBy(id = "bx_basketFKauiI")
    WebElement basketButton;

    public void searchByArticle() {
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(searchInput));
        searchInput.click();
        searchInput.sendKeys("Арт. 604722");
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(foodPict)); //надо как то заменить ожидание
            foodPict.click();
        } catch (Exception e) {
            System.out.println("Desired food is not available");
        }
    }

    public void getOrder() {
        wait.until(ExpectedConditions.visibilityOfAllElements(orderButton));
        orderButton.click();
    }

    public void clickBasketButton(){
        basketButton.click();
    }
}