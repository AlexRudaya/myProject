package basepage;

import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MtsPage {
    WebDriver driver;
    @FindBy(xpath="//div[@class ='pay__wrapper' ]/h2")
    WebElement cookiePopUp;
    @FindBy(xpath="//button[3]")
    WebElement cookieButton;
    @FindBy(xpath="//div[@class ='pay__wrapper' ]/h2")
    WebElement sectionName;

    @FindBy(xpath="//div[@class='pay__partners']//ul/li/img")
    List<WebElement> listOfIcons;


    public void checkPopUp(){
        if (cookiePopUp.isDisplayed()) {
            System.out.println("inside if");
            cookieButton.click();
        } else {
            System.out.println("ignored");
        }

    }
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
      public MtsPage(WebDriver driver) {
        this.driver = driver;
        init(driver);
    }


    public String getSectionText(){
        return sectionName.getText();
    }

    public ArrayList<String> checkPaymentIcon (){
        ArrayList<String> array= new ArrayList<>();
        for (int i = 0; i < listOfIcons.size(); i++) {
            array.set(i, listOfIcons.get(i).getAttribute("alt"));
            System.out.println(array.get(i));
        }
        return array;
    }

}
