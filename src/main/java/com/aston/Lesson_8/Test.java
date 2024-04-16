package com.aston.Lesson_8;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;

public class Test {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resourses/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mts.by");

        //если появился поп ап с куки
        if (driver.findElement(By.xpath("//div[@class='cookie__wrapper']")).isDisplayed()) {
            driver.findElement(By.xpath("//button[3]")).click();
        }

        //проверяем имя секции
        try {
            //есть ли секция в целом
            driver.findElement(By.xpath("//section[@class = \"pay\"]")).isDisplayed();
            try {
                //правильное ли у нее имя
                WebElement h = driver.findElement(By.xpath("//div[@class ='pay__wrapper' ]/h2"));
                if (h.getText().equals("Онлайн пополнение\n" + "без комиссии")) {
                    System.out.println("Correct");
                } else {
                    System.out.println("Incorrect title");
                }

            } catch (Exception e) {
                throw new NoSuchElementException("No title is present");

            }
        } catch (Exception e) {
            throw new NoSuchElementException("No such element");
        }


    }
}
