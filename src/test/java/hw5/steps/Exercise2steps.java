package hw5.steps;

import hw5.Browser;
import hw5.DifferentElements;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2steps extends BaseSteps{

    private DifferentElements differentElements;

    public Exercise2steps(Browser browser) {
        super(browser);
    }

    private List<String> possibleElements = Arrays.asList("Water", "Earth", "Wind", "Fire");
    private List<String> expectedElements;
    private Map<String, Boolean> actualElements = new HashMap<>();

    private List<String> possibleMetals = Arrays.asList("Gold", "Silver", "Bronze", "Selen");
    private String expectedMetal;
    private String actualMetal = "";

    private List<String> possibleColors = Arrays.asList("Blue", "Yellow", "Green", "Red");
    private String expectedColor;
    private String actualColor = "Red";

    @Step("Go to the Different Elements")
    public void openDifferentElements (){
        homePage.goToDifferentElements();
        differentElements = browser.getDifferentElements();
    }

    @Step("Select checkboxes")
    public void selectCheckboxes(List<String> expectedSelectedElements){
        differentElements.setCheckboxes(expectedSelectedElements);
        this.expectedElements = expectedSelectedElements;
    }

    @Step("Select radios")
    public void selectRadios (String expectedMetal){
        differentElements.setRadios(expectedMetal);
        this.expectedMetal = expectedMetal;
    }

    @Step("Select color")
    public void selectColor (String expectedColor){
        differentElements.setColor(expectedColor);
        this.expectedColor = expectedColor;
    }

    @Step("Parse logs")
    public void parseLogs (){
        differentElements.splitLogs();
        actualColor = differentElements.findColor();
        actualMetal = differentElements.findMetal();
        differentElements.findElements(actualElements);
        for (String s : possibleElements){
            if (!actualElements.containsKey(s)){
                actualElements.put(s, false);
            }
        }
    }

    @Step("Check actual color")
    public void checkActualColor(){
        assertEquals(actualColor, expectedColor);
    }

    @Step("Check actual metal")
    public void checkActualMetal(){
        assertEquals(actualMetal, expectedMetal);
    }

    @Step("Check actual elements")
    public void checkActualElements(){
        for (String s : actualElements.keySet()){
            assertEquals(actualElements.get(s).booleanValue(), expectedElements.contains(s));
        }
    }

    @Step("Check logged color")
    public void checkLoggedColor (){
        assertTrue(differentElements.checkColor(actualColor));
    }

    @Step("Check logged metal")
    public void checkLoggedMetal (){
        assertTrue(differentElements.checkRadios(actualMetal));
    }

    @Step("Check logged Elemets")
    public void checkLoggedElements (){
        assertTrue(differentElements.checkCheckboxes(actualElements));
    }
}
