package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    String streetName = "Пушкинская";
    String buildingNum = "100";
    String roomNum = "25";
    String personName = "Александра";
    String phoneNum = "297777777";
    String emailValue = "email@email.com";

    @FindBy(xpath = ".//a[@city-id='2406']")
    WebElement selectCity;
    @FindBy(xpath = "//div[@class='order__block average']//img[@src='/bitrix/templates/gar_new/icons/arrow-black.svg']")
    WebElement cityDropDown;
    @FindBy(xpath = ".//h1[text()='Оформление заказа']")
    WebElement labelForOrder;

    @FindBy(xpath = "//label[@data-id='express']/span")
    WebElement deliveryType;

    @FindBy(xpath = "/html/body/form/div/div[1]/div[4]/label[1]/input")
    WebElement currentDate;

    @FindBy(xpath = "/html/body/form/div/div[1]/div[6]/label[3]/span")
    WebElement paymentType;

    @FindBy(xpath = "//input[@placeholder='Улица']")
    WebElement street;
    @FindBy(xpath = "//input[@placeholder='Дом']")
    WebElement building;
    @FindBy(xpath = "//input[@placeholder='Квартира']")
    WebElement room;
    @FindBy(xpath = "//input[@placeholder='Имя']")
    WebElement name;
    @FindBy(xpath = "//input[@placeholder='Телефон']")
    WebElement phone;
    @FindBy(xpath = "//input[@placeholder='Почта']")
    WebElement email;
    @FindBy(xpath = "//a[@class='cart-order__continue']")
    WebElement continueOrderButton;
    private BasketPage basketP;
    WebDriver driver;
    WebDriverWait wait;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);


    }

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
        basketP = new BasketPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    public void selectCityFromDropDown() {
        cityDropDown.click();
        selectCity.click();
    }

    public void navigateToOrderPage() {
        basketP.navigateToOrder();
        wait.until(ExpectedConditions.visibilityOfAllElements(labelForOrder));
    }

//    public void selectDateOfDelivery() throws InterruptedException {
//        System.out.println(currentDate.getAttribute("value"));
//        currentDate.sendKeys("04.06.2024");
//        Thread.sleep(1000);
//    }

    public void populateAddress() {
        street.sendKeys(streetName);
        building.sendKeys(buildingNum);
        room.sendKeys(roomNum);

    }

    public WebElement getPaymentType() {
        return paymentType;
    }

    public void choosePaymentType() {
        paymentType.click();
    }

    public void populateMandatoryFields()  {
        selectCityFromDropDown();
        deliveryType.click();

    }


    public void populatePersonalInfo() {
        name.sendKeys(personName);
        phone.sendKeys(phoneNum);
        email.sendKeys(emailValue);
    }

    public void finalizeOrder() {
        continueOrderButton.click();
    }
}
