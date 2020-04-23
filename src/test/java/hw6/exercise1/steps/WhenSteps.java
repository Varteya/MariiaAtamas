package hw6.exercise1.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;

import java.util.Arrays;
import java.util.List;

public class WhenSteps extends BaseWithDataStorage {


    @When("I perform login as {string} with password {string} on the JDI-testing home page")
    public void iPerformLoginOnTheJDITestingHomePage(String login, String password) {
        browser.getHomePage().login(login, password);
    }

    @When("I click to Service button on the header on the JDI-testing home page")
    public void iClickToServiceButtonOnTheHeaderOnTheJDITestingHomePage() {
        browser.getHomePage().clickServiceButton();
    }

    @When("I click to Different Elements button in dropdown on the JDI-testing home page")
    public void iClickToDifferentElementsButtonInDropdownOnTheJDITestingHomePage() {
        browser.getHomePage().goToDifferentElements();
    }

    @When("I choose checkboxes on the Different Elements Page:")
    public void iChooseCheckboxesOnTheDifferentElementsPage(DataTable dataTable) {
        List<String> elements = dataTable.asList();
        browser.getDifferentElements().setCheckboxes(elements);
        expectedElements = elements;
    }

    @When("I choose radio {string} on the Different Elements Page")
    public void iChooseRadioOnTheDifferentElementsPage(String metal) {
        browser.getDifferentElements().setRadios(metal);
        expectedMetal = metal;
    }

    @When("I choose dropdown {string} on the Different Elements Page")
    public void iChooseDropdownOnTheDifferentElementsPage(String color) {
        browser.getDifferentElements().setColor(color);
        expectedColor = color;
    }
}
