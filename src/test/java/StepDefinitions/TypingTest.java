package StepDefinitions;

import POM.TypingPOM;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class TypingTest extends BaseMethods {

    TypingPOM typingPOM;
    List<WebElement> exampleText;

    public TypingTest(){
        typingPOM = TypingPOM.getInstance();
//        exampleText = driver.findElements(typingPOM.getTextWord());
    }



    @Given("User is in Typing-test page")
    public void UserIsInTypingTestPage(){
    }


    @When("User clicks on Typing Test mode")
    public void userClicksOnTypingTestMode() {
        driver.findElement(typingPOM.getCookieDeclineBtn()).click();
        driver.findElement(typingPOM.getTypingTestLink()).click();
    }

    @And("User fills text input line")
    public void userFillsTextInputLine() {
        exampleText = driver.findElements(typingPOM.getTextWord());
        for (WebElement element : exampleText){
            WebElement inputText = driver.findElement(typingPOM.getInputTextField());
            inputText.sendKeys(element.getText());
            inputText.sendKeys(Keys.SPACE);
        }
    }

    @Then("Each word should change to green color")
    public void eacbWordShouldBeGreen() {
        for (WebElement element : exampleText){
            if (element.getAttribute("class").equals("correct")) Assert.assertTrue(true);
            else throw new AssertionError();
        }
    }

    @And("User fills incorrect text in input line")
    public void userFillsIncorrectTextInInputLine() {
        exampleText = driver.findElements(typingPOM.getTextWord());
        for (WebElement element : exampleText){
            WebElement inputText = driver.findElement(typingPOM.getInputTextField());
            inputText.sendKeys(element.getText().toUpperCase());
            inputText.sendKeys(Keys.SPACE);
        }
    }

    @Then("Each word should change to red color")
    public void eachWordShouldChangeToRedColor() {
        for (WebElement element : exampleText){
            if (element.getAttribute("class").equals("wrong")) Assert.assertTrue(true);
            else throw new AssertionError();
        }
    }

    @Then("Next word in text should be highlighted")
    public void nextWordInTextShouldBeHighlighted() {
        exampleText = driver.findElements(typingPOM.getTextWord());
        Assert.assertEquals(exampleText.getFirst().getAttribute("class"), "highlight");
        for (int i=0; i<exampleText.size(); i++){
            WebElement inputText = driver.findElement(typingPOM.getInputTextField());
            inputText.sendKeys(exampleText.get(i).getText());
            inputText.sendKeys(Keys.SPACE);
            if (exampleText.get(i) == exampleText.getLast()) break;
            Assert.assertEquals(exampleText.get(i+1).getAttribute("class"), "highlight");
        }
    }

    @When("User fills wrong keys in text input")
    public void userFillsWrongKeysInTextInput() {
        exampleText = driver.findElements(typingPOM.getTextWord());
        driver.findElement(typingPOM.getInputTextField()).sendKeys(exampleText.getFirst().getText().toUpperCase());
    }

    @Then("Current word highlighting red color")
    public void currentWordHighlitingRedColor() {
        Assert.assertEquals(exampleText.getFirst().getAttribute("class"), "highlight-wrong");
    }
}
