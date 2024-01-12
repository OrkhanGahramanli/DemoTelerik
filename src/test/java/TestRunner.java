import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (
        features = {"classpath:features"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
