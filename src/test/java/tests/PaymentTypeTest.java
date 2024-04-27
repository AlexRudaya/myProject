/**Проверить надписи в незаполненных полях каждого варианта
 оплаты услуг: услуги связи, домашний интернет, рассрочка,
 задолженность; */
package tests;

import basepage.MtsPage;
import basepage.PaymentTypeDropDown;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestSetup;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PaymentTypeTest extends TestSetup {

    private WebDriver driver;
    private PaymentTypeDropDown paymentType;
    private MtsPage mtsPage;
    WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofMillis(3000));


    @BeforeAll
    public void setUpDriver() {
        driver = getDriver();
        mtsPage = new MtsPage(driver);
        mtsPage.checkPopUp();
        paymentType = new PaymentTypeDropDown(driver);

    }

    @Test
    public void homeInternet() {
        paymentType.getDropDownPay().click();
        paymentType.getHomeInet().click();
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofMillis(30000));
        waitFrame.until(ExpectedConditions.visibilityOfAllElements(paymentType.getInetNumber()));
//  не работает,если раскомментить
//      paymentType.getInetNumber().click();
        paymentType.getInetNumber().sendKeys("3333333");
        assertAll(
                () -> assertTrue(paymentType.getInetNumber().isDisplayed()),
                () -> assertTrue(paymentType.getInetSum().isDisplayed()),
                () -> assertTrue(paymentType.getInetEmail().isDisplayed()),
                () -> assertEquals("Номер абонента", paymentType.getInetNumber().getAttribute("placeholder")),
                () -> assertEquals("Сумма", paymentType.getInetSum().getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", paymentType.getInetEmail().getAttribute("placeholder"))
        );
    }

    @Test
    public void installment() {
        paymentType.getDropDownPay().click();
        paymentType.getInstallment().click();
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofMillis(3000));
        waitFrame.until(ExpectedConditions.visibilityOfAllElements(paymentType.getInstEmail()));
        paymentType.getInstEmail().click();
        paymentType.getInstEmail().sendKeys("111");
        //Thread.sleep(3000);
        assertAll(
                () -> assertTrue(paymentType.getInstScore().isDisplayed()),
                () -> assertTrue(paymentType.getInstSum().isDisplayed()),
                () -> assertTrue(paymentType.getInstEmail().isDisplayed()),
                () -> assertEquals("Номер счета на 44", paymentType.getInstScore().getAttribute("placeholder")),
                () -> assertEquals("Сумма", paymentType.getInstSum().getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", paymentType.getInstEmail().getAttribute("placeholder"))
        );
    }

    @Test
    public void arrears() {
        paymentType.getDropDownPay().click();
        paymentType.getArrears().click();
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofMillis(3000));
        waitFrame.until(ExpectedConditions.visibilityOfAllElements(paymentType.getArrEmail()));
        paymentType.getArrSum().click();
        paymentType.getArrEmail().sendKeys("111");
        paymentType.getArrScore().sendKeys("111");
        paymentType.getArrSum().sendKeys("111");
        assertAll(
                () -> assertTrue(paymentType.getArrScore().isDisplayed()),
                () -> assertTrue(paymentType.getArrSum().isDisplayed()),
                () -> assertTrue(paymentType.getArrEmail().isDisplayed()),
                //  () -> assertTrue(paymentType.getInetEmail().isDisplayed()),
                () -> assertEquals("Номер счета на 2073", paymentType.getArrScore().getAttribute("placeholder")),
                () -> assertEquals("Сумма", paymentType.getArrSum().getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", paymentType.getArrEmail().getAttribute("placeholder"))
        );
    }

    @Test
    public void connections() {
        paymentType.getDropDownPay().click();
        paymentType.getConnections().click();
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofMillis(3000));
        waitFrame.until(ExpectedConditions.elementToBeClickable(paymentType.getConEmail()));
        paymentType.getConEmail().click();
        paymentType.getConEmail().sendKeys("111");
        paymentType.getArrScore().sendKeys("111");
        paymentType.getArrSum().sendKeys("111");
        assertAll(
                () -> assertTrue(paymentType.getConPhone().isDisplayed()),
                () -> assertTrue(paymentType.getConSum().isDisplayed()),
                () -> assertTrue(paymentType.getConEmail().isDisplayed()),
                () -> assertEquals("Номер телефона", paymentType.getConPhone().getAttribute("placeholder")),
                () -> assertEquals("Сумма", paymentType.getConSum().getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", paymentType.getConEmail().getAttribute("placeholder"))
        );
    }
}
