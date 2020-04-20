package hw6.exercise2;

import hw6.BaseStep;
import hw6.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class GivenSteps extends BaseStep {

    @Given("I open JDI GitHub site")
    public void openSite (){
        WebDriverManager.chromedriver().setup();
        browser = new Browser(new ChromeDriver());
        browser.getHomePage().openSite("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Given("I login as user {string}")
    public void iLoginAsUser(String arg0) {
        browser.getHomePage().login("Roman", "Jdi1234");
    }
}
