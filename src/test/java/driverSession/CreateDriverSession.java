package driverSession;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateDriverSession {
    public static WebDriver driver;

    @Before
    public void startDriver()
    {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("chrome.switches\", \"--disable-extensions");
//        options.addArguments("user-data-dir=C:/Users/orkhan.gahramanli/AppData/Local/Google/Chrome/User Data/");
//        options.addArguments("profile-directory=Profile 1");
        driver = new ChromeDriver();
        driver.get("https://10fastfingers.com/typing-test/english");
    }

    @After
    public void quitDriver()
    {
        driver.quit();
    }
}
