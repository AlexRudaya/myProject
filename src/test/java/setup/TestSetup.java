package setup;

import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestSetup {
    public static WebDriver driver;
    static String url="http://mts.by";

    public WebDriver getDriver() {
        return driver;
    }

    private static void setDriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    @BeforeAll
    public void setUp() {
        setDriver();
        //если появился поп ап с куки
            }

    @AfterAll
    public static void closeDriver() {
        driver.quit();
    }

}
