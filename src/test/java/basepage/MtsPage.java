package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MtsPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class ='pay__wrapper' ]/h2")
    WebElement cookiePopUp;
    @FindBy(xpath = "//button[3]")
    WebElement cookieButton;
    @FindBy(xpath = "//div[@class ='pay__wrapper' ]/h2")
    WebElement sectionName;

    @FindBy(xpath = "//div[@class='pay__partners']//ul/li/img")
    List<WebElement> listOfIcons;

    @FindBy(xpath = "//input[@class='phone']")
    WebElement phoneNumber;
    @FindBy(xpath = "//form[1]/button['Продолжить']")
    WebElement continueButton;
    @FindBy(xpath = "//input[@class='total_rub']")
    WebElement rub;
    @FindBy(xpath = "//input[@class='email']")
    WebElement email;

    String phoneNumberValue = "297777777";
    String rubValue = "20";
    String emailValue = "email@email.com";

    public void checkPopUp() {
        if (cookiePopUp.isDisplayed()) {
             cookieButton.click();
        }

    }

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
    }


    public String getSectionText() {
        return sectionName.getText();
    }


    public String checkPaymentIcon(int i) {
        return listOfIcons.get(i).getAttribute("alt");
    }

    public void phoneFields() {
        phoneNumber.click();
        phoneNumber.sendKeys(phoneNumberValue);
        rub.click();
        rub.sendKeys(rubValue);
        email.click();
        email.sendKeys(emailValue);
        continueButton.click();
    }


    public double getRubValue() {
        double rubCheck = Double.parseDouble(rubValue);
        return rubCheck;
    }

    public String getPhoneNumberValue() {
        return phoneNumberValue;
    }

}
