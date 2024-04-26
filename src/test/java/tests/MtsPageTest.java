package tests;

import basepage.MtsPage;
import basepage.ServiceInfoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.TestSetup;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class MtsPageTest extends TestSetup {
    private  WebDriver driver;
    private MtsPage mtsPage;
    private ServiceInfoPage servicePage;

    @BeforeAll
    public void setUpDriver() {
        driver = getDriver();
        mtsPage=new MtsPage(driver);
        mtsPage.checkPopUp();
        servicePage=new ServiceInfoPage(driver);
    }

    @Test
    public void verifyTitle() {
        Assertions.assertEquals("Онлайн пополнение\n" + "без комиссии", mtsPage.getSectionText());
    }

    @Test
    //проверяем типы оплат
    public void paymentsIconsPresence() {
        assertAll(
                () -> assertEquals("Visa", mtsPage.checkPaymentIcon(0)),
                () -> assertEquals("Verified By Visa", mtsPage.checkPaymentIcon(1)),
                () -> assertEquals( "MasterCard", mtsPage.checkPaymentIcon(2)),
                () -> assertEquals("MasterCard Secure Code", mtsPage.checkPaymentIcon(3)),
                () -> assertEquals("Белкарт", mtsPage.checkPaymentIcon(4)),
                () -> assertEquals("МИР", mtsPage.checkPaymentIcon(5))
        );
    }

    @Test
    public void validationOfLink(){
        servicePage.checkLinkWithDuration();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.urlMatches("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        driver.navigate().back();
    }



}
