import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class googleTest {

    //System.setProperty("webdriver.chrome.driver", "/Users/diabomba/Desktop/chromedriver.exe");
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the Google homepage")
    public void openGoogleHomepage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.google.com");
        //close the specific pop up that appears
        //improvements would be to conditionally verify its presence and define the action for it
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("L2AGLb"))).click();
        driver.manage().window().maximize();
        //driver.findElement(By.id("L2AGLb")).click();
    }

    @When("I search for the keyword $keyword")
    public void searchForKeyword(String keyword) {

        driver.findElement(By.name("q")).sendKeys(keyword, Keys.ENTER);
        }

    @Then("the search results should include the string $phrase")
    public void verifySearchResults(String phrase) {
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
        //driver.findElement(By.tagName("h3"));

        assertEquals(result.getText(),phrase.replaceAll("\"",""));
        driver.quit();
    }

    @Then("the search results should NOT include the string $phrase")
    public void verifySearchResultsNegative(String phrase) {
        WebElement result = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h3")));
        //driver.findElement(By.tagName("h3"));

        assertNotEquals(result.getText(),phrase.replaceAll("\"",""));
        driver.quit();
    }

}
