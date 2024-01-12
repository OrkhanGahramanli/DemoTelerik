package StepDefinitions;

import driverSession.CreateDriverSession;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class BaseMethods {

    public WebDriver driver = CreateDriverSession.driver;
}
