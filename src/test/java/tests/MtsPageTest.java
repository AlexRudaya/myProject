package tests;

import basepage.MtsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import setup.TestSetup;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class MtsPageTest extends TestSetup {
    private  WebDriver driver;
    private MtsPage mtsPage;

    @BeforeAll
    public void setUpDriver() {
        driver = getDriver();
        mtsPage=new MtsPage(driver);
        mtsPage.checkPopUp();
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", mtsPage.getSectionText());
    }

    @Test
    //проверяем типы оплат
    public void payments() {
        assertAll(
                () -> assertEquals("Visa", mtsPage.checkPaymentIcon().get(1)),
                () -> assertEquals("Verified By Visa", mtsPage.checkPaymentIcon().get(1)),
                () -> assertEquals("MasterCard", mtsPage.checkPaymentIcon().get(1)),
                () -> assertEquals("MasterCard Secure Code", mtsPage.checkPaymentIcon().get(1)),
                () -> assertEquals("Белкарт", mtsPage.checkPaymentIcon().get(1)),
                () -> assertEquals("МИР", mtsPage.checkPaymentIcon().get(1))
        );
    }
}
