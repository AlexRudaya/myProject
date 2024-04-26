package basepage;

import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Frame {
    WebDriver driver;
    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    WebElement frameLink;
    @FindBy(xpath = "//app-card-page//app-google-pay//button['Google Pay']")
    WebElement googleButton;

    @FindBy(xpath = "//div[@class='pay-description__cost']")
    WebElement paymentMethod;
    @FindBy(xpath = "//div[@class='card-page__card']/button[@type='submit']")
    WebElement buttonLabel;
    @FindBy(xpath = "//span[@class='pay-description__text']")
    WebElement textPhone;


    @FindBy(xpath = ".//app-card-input/form/div[1]/div[1]/app-input//div[1]/label")
    WebElement cardNumber;
    @FindBy(xpath = "//app-card-input/form//div[2]/div[1]/app-input//div[1]/label")
    WebElement expiration;
    @FindBy(xpath = "//app-card-input/form/div[1]/div[2]/div[3]/app-input//div[1]/label")
    WebElement cvc;
    @FindBy(xpath = "//app-card-input/form/div[1]/div[3]/app-input//div[1]/label")
    WebElement owner;
    @FindBy(css ="img[src='assets/images/payment-icons/card-types/mastercard-system.svg']" )
    WebElement masterCardIcon;
    @FindBy(css="img[src='assets/images/payment-icons/card-types/visa-system.svg']")
    WebElement visaIcon;
    @FindBy(css="img[src='assets/images/payment-icons/card-types/belkart-system.svg'")
    WebElement belcardIcon;
    @FindBy(css="img[src='assets/images/payment-icons/card-types/mir-system-ru.svg']")
    WebElement mirIcon;
    @FindBy(css="img[src='assets/images/payment-icons/card-types/maestro-system.svg']")
    WebElement maestroIcon;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Frame(WebDriver driver) {
        this.driver = driver;
        init(driver);
    }
    public String getCardNumberText(){
        return cardNumber.getText();
    }
    public String getExpirationText(){
        return  expiration.getText();
    }
    public String getCvcText(){
        return cvc.getText();
    }
    public String getOwnerText(){
        return owner.getText();
    }

    public WebElement loadFrameLink() {
        return frameLink;
    }

    public double paymentMethodLabel() {
        String paymentLabel = paymentMethod.getText();
        double paymentByn = Double.parseDouble(paymentLabel.substring(0, paymentLabel.length() - 4));
        return paymentByn;
    }

    public double paymentButton() {
        String paymentButtonLabel = buttonLabel.getText();
        double paymentBtnByn = Double.parseDouble(paymentButtonLabel.substring(9, paymentButtonLabel.length() - 4));
        return paymentBtnByn;
    }

    public String phoneLabelOnButton() {
        String fullLabelPhone = textPhone.getText();
        String labelPhone = fullLabelPhone.substring(fullLabelPhone.length() - 9, fullLabelPhone.length());
        return labelPhone;
    }

    public WebElement getMasterCardIcon(){
        return masterCardIcon;
    }

    public WebElement getVisaIconIcon(){
        return visaIcon;
    }
    public WebElement getBelcardIconIcon(){
        return belcardIcon;
    }

    public WebElement getMirIconIcon(){
        return mirIcon;
    }
    public WebElement getMaestroIcon(){
        return maestroIcon;
    }
}
