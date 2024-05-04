package steps;

import basepage.BasketPage;
import basepage.OrderPage;
import basepage.PetMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestSetup;

import java.time.Duration;

public class FoodOrdering extends TestSetup {

    private WebDriver driver;
    private WebDriverWait wait;
    private PetMainPage petPage;
    private BasketPage basketPage;
    private OrderPage orderPage;

    @Given("I navigate to pet site")
    public void i_navigate_to_pet_site() {
        driver = getDriver();
        petPage = new PetMainPage(driver);
        basketPage = new BasketPage(driver);
        orderPage = new OrderPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(100000));

    }

    @When("Look for the cat food")
    public void look_for_the_cat_food() {
        petPage.searchByArticle();


    }

    @When("Choose the proper")
    public void choose_the_proper() {
        petPage.getOrder();
    }

    @Then("Navigate to basket")
    public void navigate_to_basket() {
        basketPage.navigateToBasket();
        basketPage.checkPresenceOfOrder();
    }

    @Then("Check the food is added")
    public void check_the_food_is_added() {
        orderPage.navigateToOrderPage();
    }


    @And("Make an order")
    public void makeAnOrder() throws InterruptedException {
        orderPage.populateMandatoryFields();
        orderPage.populateAddress();
        orderPage.populatePersonalInfo();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView();", orderPage.getPaymentType());
//НЕ РАБОТАЕТ БЕЗ ОСТАНОВКИ ПОТОКА ПОЧЕМУ-ТО
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfAllElements(orderPage.getPaymentType()));
        orderPage.choosePaymentType();
        //orderPage.finalizeOrder();
        Thread.sleep(1000);
    }
}
