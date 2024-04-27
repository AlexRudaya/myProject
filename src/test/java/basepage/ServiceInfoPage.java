package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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

    }


}
