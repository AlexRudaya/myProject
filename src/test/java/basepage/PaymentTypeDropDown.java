package basepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentTypeDropDown {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='select__wrapper']")
    WebElement dropDownPay;
    @FindBy(xpath = "//p[text()='Домашний интернет']")
    WebElement homeInet;
    @FindBy(id = "internet-phone")
    WebElement inetNumber;
    @FindBy(id = "internet-sum")
    WebElement inetSum;
    @FindBy(id = "internet-email")
    WebElement inetEmail;
    @FindBy(xpath = "//p[text()='Рассрочка']")
    WebElement installment;
    @FindBy(id = "score-instalment")
    WebElement instScore;
    @FindBy(id = "instalment-sum")
    WebElement instSum;
    @FindBy(id = "instalment-email")
    WebElement instEmail;
    @FindBy(xpath = "//p[text()='Задолженность']")
    WebElement arrears;
    @FindBy(id = "score-arrears")
    WebElement arrScore;
    @FindBy(id = "arrears-sum")
    WebElement arrSum;
    @FindBy(id = "arrears-email")
    WebElement arrEmail;


    @FindBy(xpath = "//p[text()='Услуги связи']")
    WebElement connections;
    @FindBy(id = "connection-phone")
    WebElement conPhone;
    @FindBy(id = "connection-sum")
    WebElement conSum;
    @FindBy(id = "connection-email")
    WebElement conEmail;


    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public PaymentTypeDropDown(WebDriver driver) {
        this.driver = driver;
        init(driver);
    }

    public WebElement getDropDownPay() {
        return dropDownPay;
    }

    public WebElement getHomeInet() {
        return homeInet;
    }

    public WebElement getInetNumber() {
        return inetNumber;
    }

    public WebElement getInetSum() {
        return inetSum;
    }

    public WebElement getInetEmail() {
        return inetEmail;
    }

    public WebElement getInstallment() {
        return installment;
    }

    public WebElement getInstEmail() {
        return instEmail;
    }

    public WebElement getInstScore() {
        return instScore;
    }

    public WebElement getInstSum() {
        return instSum;
    }

    public WebElement getArrears() {
        return arrears;
    }

    public WebElement getArrEmail() {
        return arrEmail;
    }

    public WebElement getArrScore() {
        return arrScore;
    }

    public WebElement getArrSum() {
        return arrSum;
    }

    public WebElement getConnections() {
        return connections;
    }

    public WebElement getConEmail() {
        return conEmail;
    }

    public WebElement getConPhone() {
        return conPhone;
    }

    public WebElement getConSum() {
        return conSum;
    }
}
