package hw6.exercise1.steps;

import hw6.po.DifferentElements;
import hw6.po.HomePage;
import io.cucumber.java.en.Then;

import java.util.HashMap;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ThenSteps extends BaseStep {

    private Map<String, Boolean> actualElements = new HashMap<>();
    private String actualMetal = "";
    private String actualColor = "Red";


    @Then("URL should be {string} on the JDI-testing home page")
    public void urlShouldBeHttpsJdiTestingGithubIoJdiLightIndexHtmlOnTheJDITestingHomePage(String expected) {
        HomePage homePage = browser.getHomePage();
        assertTrue(homePage.checkURL(expected));
    }

    @Then("Browser title should be equals {string}")
    public void browserTitleShouldBeEquals(String expected) {
        HomePage homePage = browser.getHomePage();
        assertTrue(homePage.checkHeader(expected));
    }

    @Then("I should be loggined as {string} on the JDI-testing home page")
    public void iShouldBeLogginedOnTheJDITestingHomePage(String expected) {
        HomePage homePage = browser.getHomePage();
        assertTrue(homePage.logoutButtonHasAppeared());
        assertTrue(homePage.checkUsername(expected));
    }


    @Then("URL should be {string} on the Different Elements Page")
    public void urlShouldBeHttpsJdiTestingGithubIoJdiLightDifferentElementsHtmlOnTheDifferentElementsPage(String expected) {
        DifferentElements differentElements = browser.getDifferentElements();
        assertTrue(differentElements.checkURL(expected));
    }

    @Then("Logs should be correct for chosen values on the Different Elements Page")
    public void logsShouldBeCorrectForChosenValuesOnTheDifferentElementsPage() {
        DifferentElements differentElements = browser.getDifferentElements();
        differentElements.splitLogs();
        actualColor = differentElements.findColor();
        actualMetal = differentElements.findMetal();
        differentElements.findElements(actualElements);
        for (String s : differentElements.getPossibleElements()){
            if (!actualElements.containsKey(s)){
                actualElements.put(s, false);
            }
        }

        assertEquals(actualColor, expectedColor);
        assertEquals(actualMetal, expectedMetal);
        for (String s : actualElements.keySet()){
            assertEquals(actualElements.get(s).booleanValue(), expectedElements.contains(s));
        }
    }

    @Then("Chosen values should be as same as expected on the Different Elements Page")
    public void chosenValuesShouldBeAsSameAsExpectedOnTheDifferentElementsPage() {
        DifferentElements differentElements = browser.getDifferentElements();
        assertTrue(differentElements.checkCheckboxes(actualElements));
        assertTrue(differentElements.checkRadios(actualMetal));
        assertTrue(differentElements.checkColor(actualColor));
    }

}
