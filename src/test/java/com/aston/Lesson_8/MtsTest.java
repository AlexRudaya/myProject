package com.aston.Lesson_8;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MtsTest {
    public static WebDriver driver;
 //   Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    @BeforeAll

    public static void mainPage() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by"); //ВСТАВИТЬ В КАЖДЫЙ ТЕСТ

        //если появился поп ап с куки
        if (driver.findElement(By.xpath("//div[@class='cookie__wrapper']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[3]")).click();
        }

    }

//    @Test
//    public void sectionTitle() {
//        //проверяем имя секции
//        driver.get("http://mts.by");
//        //driver.findElement(By.xpath("//section[@class = \"pay\"]")).isDisplayed();
//        WebElement h = driver.findElement(By.xpath("//div[@class ='pay__wrapper' ]/h2"));
//        assertEquals("Онлайн пополнение\n" + "без комиссии", h.getText());
//    }

//    @Test
//    //проверяем ссылку
//    public void checkLink() {
//        driver.get("http://mts.by");
//        driver.findElement(By.xpath("//section/div[@class='pay__wrapper']/a[contains(text(),'Подробнее о сервисе')]")).click();
//        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());
//
//    }
//
//    @Test
//    //проверяем ссылку с ожиданием
//    public void checkLinkDuration() {
//     driver.get("http://mts.by");
//     driver.findElement(By.xpath("//section/div[@class='pay__wrapper']/a[contains(text(),'Подробнее о сервисе')]")).click();
//     new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlMatches("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
//    }

//    @Test
//    //проверяем типы оплат
//    public void payments() {
//        driver.get("http://mts.by");
//        List<WebElement> listOfLinks = driver.findElements(By.xpath("//div[@class='pay__partners']//ul/li/img"));
//        assertAll(
//                () -> assertEquals("Visa", listOfLinks.get(0).getAttribute("alt")),
//                () -> assertEquals("Verified By Visa", listOfLinks.get(1).getAttribute("alt")),
//                () -> assertEquals("MasterCard", listOfLinks.get(2).getAttribute("alt")),
//                () -> assertEquals("MasterCard Secure Code", listOfLinks.get(3).getAttribute("alt")),
//                () -> assertEquals("Белкарт", listOfLinks.get(4).getAttribute("alt")),
//                () -> assertEquals("МИР",listOfLinks.get(5).getAttribute("alt"))
//        );
//    }

    @Test
    //кнопка "Продолжить"
    public void checkButton() throws InterruptedException {
        WebElement phoneNumber = driver.findElement(By.xpath("//input[@class='phone']"));
        WebElement continueButton = driver.findElement(By.xpath("//form[1]/button['Продолжить']"));
        WebElement rub = driver.findElement(By.xpath("//input[@class='total_rub']"));
        WebElement email = driver.findElement(By.xpath("//input[@class='email']"));


        phoneNumber.click();
        phoneNumber.sendKeys("297777777");
        rub.click();
        rub.sendKeys("100");
        email.click();
        email.sendKeys("swallow88@yandex.ru");
        continueButton.click();

        WebDriverWait waitFrame = new WebDriverWait(driver, Duration.ofSeconds(30));
        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@class='bepaid-iframe']")));

        waitFrame.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-card-page//app-google-pay//button['Google Pay']")));

        //сумма в заголовке
        WebElement paymentMethod = driver.findElement(By.xpath("//div[@class='pay-description__cost']"));
        //сумма на кнопке
        WebElement buttonLabel = driver.findElement(By.xpath("//div[@class='card-page__card']/button[@type='submit']"));
        String button = buttonLabel.getText();
        //номер телефона
        WebElement textPhone = driver.findElement(By.xpath("//span[@class='pay-description__text']"));
        String phone = textPhone.getText();
        assertAll(
                () -> assertEquals("100.00 BYN", paymentMethod.getText()),
                () -> assertEquals("100.00 BYN", button.substring(9, button.length())),
                () -> assertEquals("375297777777", phone.substring(phone.length() - 12, phone.length()))
        );

        //текст в полях
        WebElement cardNumber = driver.findElement(By.xpath(".//app-card-input/form/div[1]/div[1]/app-input//div[1]/label"));
        WebElement expiration = driver.findElement(By.xpath("//app-card-input/form//div[2]/div[1]/app-input//div[1]/label"));
        WebElement cvc = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[2]/div[3]/app-input//div[1]/label"));
        WebElement owner = driver.findElement(By.xpath("//app-card-input/form/div[1]/div[3]/app-input//div[1]/label"));
                assertAll(
                        () -> assertEquals("Номер карты", cardNumber.getText()),
                        () -> assertEquals("Срок действия", expiration.getText()),
                        () -> assertEquals("CVC", cvc.getText()),
                        () -> assertEquals("Имя держателя (как на карте)", owner.getText())

                );
        //иконки

        WebElement masterCard =driver.findElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/mastercard-system.svg']"));
        WebElement visa = driver.findElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/visa-system.svg']"));
        WebElement belcard = driver.findElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/belkart-system.svg'"));
        WebElement mir = driver.findElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/mir-system-ru.svg']"));
        WebElement maestro = driver.findElement(By.cssSelector("img[src='assets/images/payment-icons/card-types/maestro-system.svg']"));

        assertAll(
                () ->assertTrue(masterCard.isDisplayed()),
                () ->assertTrue(visa.isDisplayed()),
                () ->assertTrue(belcard.isDisplayed()),
                () ->assertTrue(mir.isDisplayed()),
                () ->assertTrue(maestro.isEnabled()) //????????почему не работает с displayed
        );

    }


    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

}

