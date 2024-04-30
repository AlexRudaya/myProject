/**Проверить надписи в незаполненных полях каждого варианта
 оплаты услуг: услуги связи, домашний интернет, рассрочка,
 задолженность; */
package tests;

import basepage.MtsPage;
import basepage.PaymentTypeDropDown;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestSetup;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class PaymentTypeTest extends TestSetup {

    private WebDriver driver;
    private PaymentTypeDropDown paymentType;
    private MtsPage mtsPage;
    WebDriverWait wait;


    @BeforeAll
    public void setUpDriver() {
        driver = getDriver();
        mtsPage = new MtsPage(driver);
        mtsPage.checkPopUp();
        paymentType = new PaymentTypeDropDown(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(7000));
    }

    @Test
    public void homeInternet()  {
        paymentType.clickDropDownPay();
        paymentType.clickHomeInet();
        wait.until(ExpectedConditions.visibilityOf(paymentType.getInetSum()));

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
        paymentType.clickDropDownPay();
        paymentType.getInstallment().click();
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentType.getInstEmail()));

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
        paymentType.clickDropDownPay();
        paymentType.getArrears().click();
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentType.getArrEmail()));
        assertAll(
                () -> assertTrue(paymentType.getArrScore().isDisplayed()),
                () -> assertTrue(paymentType.getArrSum().isDisplayed()),
                () -> assertTrue(paymentType.getArrEmail().isDisplayed()),
                () -> assertEquals("Номер счета на 2073", paymentType.getArrScore().getAttribute("placeholder")),
                () -> assertEquals("Сумма", paymentType.getArrSum().getAttribute("placeholder")),
                () -> assertEquals("E-mail для отправки чека", paymentType.getArrEmail().getAttribute("placeholder"))
        );
    }

    @Test
    public void connections() {
        paymentType.clickDropDownPay();
        paymentType.getConnections().click();
        wait.until(ExpectedConditions.elementToBeClickable(paymentType.getConEmail()));

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
