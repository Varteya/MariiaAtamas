package hw6.exercise1.steps;

import hw6.Browser;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class GivenSteps extends BaseStep{

    @Given("I open the JDI-testing home page")
    public void iOpenTheJDITestingHomePage() {
        WebDriverManager.chromedriver().setup();
        browser = new Browser(new ChromeDriver());
        browser.getHomePage().openSite("https://jdi-testing.github.io/jdi-light/index.html");
    }
}
