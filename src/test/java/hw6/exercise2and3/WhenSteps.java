package hw6.exercise2and3;

import hw6.BaseStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class WhenSteps extends BaseStep {

    @When("I click on \"Service\" button in Header")
    public void clickServiceButton(){
        browser.getHomePage().clickServiceButton();
    }

    @When("I click on {string} button in Service dropdown")
    public void iClickOnButtonInServiceDropdown(String arg0) {
        browser.getHomePage().goToUserTable();
    }

    @When("I select vip checkbox for {string}")
    public void iSelectVipCheckboxFor(String username) {
        browser.getUserTable().selectCheckbox(username);
    }


}
