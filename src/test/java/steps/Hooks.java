package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import setup.TestSetup;

public class Hooks extends TestSetup {

    @Before
    public void setUpdDriver() {
        setUp();
    }

    @After
    public static void closeDriver() {
        driver.quit();
    }

}
