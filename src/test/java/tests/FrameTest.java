/** Для варианта «Услуги связи» заполнить поля (номер для теста
 297777777)
 6. Нажать кнопку «Продолжить» и в появившемся окне проверить
 корректность отображения суммы (в том числе на кнопке), номера
 телефона, а также надписей в незаполненных полях для ввода
 реквизитов карты, наличие иконок платёжных систем.*/

package tests;

import basepage.Frame;
import basepage.MtsPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestSetup;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class FrameTest extends TestSetup {

    private WebDriver driver;
    private Frame framePopUp;
    private MtsPage mtsPage;


    @BeforeAll
    public void setUpDriver() {
        driver = getDriver();
        framePopUp = new Frame(driver);
        mtsPage = new MtsPage(driver);
        mtsPage.checkPopUp();

    }

    @Test
    public void inputValuesAndContinue() {
        mtsPage.phoneFields();
        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(framePopUp.loadFrameLink()));
        waitFrame.until(ExpectedConditions.elementToBeClickable(framePopUp.getGoogleButton()));

    }

    @Test
    public void confirmCorrectValues() {
        assertAll(
                () -> assertEquals(mtsPage.getRubValue(), framePopUp.paymentMethodLabel()),
                () -> assertEquals(mtsPage.getRubValue(), framePopUp.paymentButton()),
                () -> assertEquals(mtsPage.getPhoneNumberValue(), framePopUp.phoneLabelOnButton())
        );
    }

    @Test
    public void emptyFieldsText() {
        assertAll(
                () -> assertEquals("Номер карты", framePopUp.getCardNumberText()),
                () -> assertEquals("Срок действия", framePopUp.getExpirationText()),
                () -> assertEquals("CVC", framePopUp.getCvcText()),
                () -> assertEquals("Имя держателя (как на карте)", framePopUp.getOwnerText())
        );
    }

    @Test
    public void confirmPayIconsPresent() {
        assertAll(
                () -> assertTrue(framePopUp.getMasterCardIcon().isDisplayed()),
                () -> assertTrue(framePopUp.getVisaIconIcon().isDisplayed()),
                () -> assertTrue(framePopUp.getMirIconIcon().isDisplayed()),
                () -> assertTrue(framePopUp.getBelcardIconIcon().isDisplayed()),
                () -> assertTrue(framePopUp.getMaestroIcon().isEnabled())
        );
    }


}
