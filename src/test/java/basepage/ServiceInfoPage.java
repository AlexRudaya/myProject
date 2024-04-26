package basepage;

import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceInfoPage {
    WebDriver driver;

    @FindBy(xpath ="//section/div[@class='pay__wrapper']/a[contains(text(),'Подробнее о сервисе')]")
    WebElement linkToClick;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ServiceInfoPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
    }

    public void checkLinkWithDuration() {
     linkToClick.click();
//     new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlMatches("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
//     driver.navigate().back();
    }


}
