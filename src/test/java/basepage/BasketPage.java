package basepage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class BasketPage {

    WebDriver driver;

    private final PetMainPage mainPage;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
        mainPage = new PetMainPage(driver);

    }
    @FindBy(xpath = "/html/body/div[6]/div[2]/div/div/div/a")
    WebElement orderPageButton;

    @FindBy(xpath = ".//p[text()='Артикул 604722']")
    WebElement orderInBasket;

//    @FindBy(xpath = ".//p[text()='Артикул 5555']")
//    WebElement orderInBasket;

    public void navigateToBasket() {
        mainPage.clickBasketButton();

    }

    public void navigateToOrder() {
        orderPageButton.click();
    }

    public void checkPresenceOfOrder() {
        try {
            assertTrue(orderInBasket.isDisplayed());
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("Order was not added to the basket");
        }

    }

}
