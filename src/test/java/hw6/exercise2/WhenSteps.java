package hw6.exercise2;

import hw6.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenSteps extends BaseStep {

    @When("I click on \"Service\" button in Header")
    public void clickServiceButton(){
        browser.getHomePage().clickServiceButton();
    }

    @And("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String arg0) {
        browser.getHomePage().goToUserTable();
    }
}
