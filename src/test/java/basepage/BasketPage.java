package basepage;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class BasketPage {

    WebDriver driver;
    WebDriverWait wait;
    private PetMainPage mainPage;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public BasketPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
        mainPage = new PetMainPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @FindBy(xpath = "/html/body/div[6]/div[2]/div/div/div/a")
    WebElement orderPageButton;

    @FindBy(xpath = ".//p[text()='Артикул 604722']")
    WebElement orderInBasket;

//    @FindBy(xpath = ".//p[text()='Артикул 5555']")
//    WebElement orderInBasket;

    public void navigateToBasket() {
        mainPage.clickBasketButton();
    //    wait.until(ExpectedConditions.visibilityOfAllElements(labelForOrder));

    }

    public void navigateToOrder() {
        orderPageButton.click();
    }

    public void checkPresenceOfOrder() {
        try {
            assertTrue(orderInBasket.isDisplayed());
            System.out.println("Order was  added to the basket");
        } catch (NoSuchElementException e) {
            System.out.println("Order was not added to the basket");
            throw new NoSuchElementException("Order was not added to the basket");
        }

    }

}
