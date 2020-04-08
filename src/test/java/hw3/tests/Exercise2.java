package hw3.tests;


import hw3.po.DifferentElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise2 extends BaseTest {

    @Test
    public void testWebDriverHardAsserts() {

        //Open test site by URL
        assertTrue(openAndCheckSite());

        //Assert Browser title
        assertTrue(homePageIsOpened());

        //Perform login
        assertTrue(login());

        //Assert User name in the left-top side of screen that user is loggined
        assertTrue(checkUsername());

        //Open through the header menu Service -> Different Elements Page
        homePage.goToDifferentElements();
        DifferentElements differentElements = browser.getDifferentElements();
        assertTrue(differentElements.checkURL("https://jdi-testing.github.io/jdi-light/different-elements.html"));

        //Select checkboxes
        List<String> expectedSelectedElements = Arrays.asList("Water", "Wind");
        differentElements.setCheckboxes(expectedSelectedElements);

        //Select radio
        String expectedMetal = "Selen";
        differentElements.setRadios(expectedMetal);

        //Select in dropdown
        String expectedColor = "Yellow";
        differentElements.setColor(expectedColor);

        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.

        List<String> possibleElements = Arrays.asList("Water", "Earth", "Wind", "Fire");
        Map<String, Boolean> actualElements = new HashMap<>();

        List<String> possibleMetals = Arrays.asList("Gold", "Silver", "Bronze", "Selen");
        String actualMetal = "";

        List<String> possibleColors = Arrays.asList("Blue", "Yellow", "Green", "Red");
        String actualColor = "Red";

        differentElements.splitLogs();
        actualColor = differentElements.findColor();
        actualMetal = differentElements.findMetal();
        differentElements.findElements(actualElements);
        for (String s : possibleElements){
            if (!actualElements.containsKey(s)){
                actualElements.put(s, false);
            }
        }

        assertEquals(actualColor, expectedColor);
        assertEquals(actualMetal, expectedMetal);
        for (String s : actualElements.keySet()){
            assertEquals(actualElements.get(s).booleanValue(), expectedSelectedElements.contains(s));
        }

        //check checkBoxes
        assertTrue(differentElements.checkCheckboxes(actualElements));

        //check radiobutton
        assertTrue(differentElements.checkRadios(actualMetal));

        //check dropdown menu
        assertTrue(differentElements.checkColor(actualColor));

    }

}
