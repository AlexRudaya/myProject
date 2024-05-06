package steps;

import basepage.BasketPage;
import basepage.OrderPage;
import basepage.PetMainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import setup.TestSetup;

public class FoodOrdering extends TestSetup {

    private WebDriver driver;
    private PetMainPage petPage;
    private BasketPage basketPage;
    private OrderPage orderPage;

    @Given("I navigate to pet site")
    public void i_navigate_to_pet_site() {
        driver = getDriver();
        petPage = new PetMainPage(driver);
        basketPage = new BasketPage(driver);
        orderPage = new OrderPage(driver);

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

    }

    @Then("Check the food is added")
    public void check_the_food_is_added() {
        basketPage.checkPresenceOfOrder();
    }


    @And("Make an order")
    public void makeAnOrder()  {
        orderPage.navigateToOrderPage();
        orderPage.populateMandatoryFields();
        orderPage.populateAddress();
        orderPage.populatePersonalInfo();
        orderPage.choosePaymentType();
        orderPage.finalizeOrder();
        orderPage.getOrderId();
    }
}
