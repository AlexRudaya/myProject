package setup;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSetup {
    public static WebDriver driver;

    static String url = "https://garfield.by/";

    public WebDriver getDriver() {
        return driver;
    }

    protected static void setDriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

    }

    public void setUp() {
        setDriver();
    }


}
