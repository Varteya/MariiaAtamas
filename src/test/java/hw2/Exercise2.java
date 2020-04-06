package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.*;

import static org.testng.Assert.*;

public class Exercise2 extends BaseTest {

    @Test
    public void testWebDriverHardAsserts() {

        //Open test site by URL
        String openedURL = openSite();
        assertEquals(openedURL, URL);

        //Assert Browser title
        assertTrue(homePageIsOpened());

        //Perform login
        assertTrue(login());

        //Assert User name in the left-top side of screen that user is loggined
        assertTrue(checkUsername());

        //Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("Service")).click();
        driver.findElement(By.linkText("Different elements")).click();
        assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/different-elements.html");

        //Select checkboxes
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("label.label-checkbox"));
        for (WebElement element : checkboxes) {
            if (element.getText().equals("Wind") || element.getText().equals("Water")) {
                element.click();
            }
        }


        //Select radio
        List<WebElement> radios = driver.findElements(By.cssSelector("div.checkbox-row > label.label-radio"));
        for (WebElement element : radios) {
            if (element.getText().equals("Selen")) {
                element.click();
            }
        }


        //Select in dropdown
        Select color = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        color.selectByVisibleText("Yellow");


        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.

        List<String> possibleElements = new ArrayList<>();
        possibleElements.add("Water");
        possibleElements.add("Earth");
        possibleElements.add("Wind");
        possibleElements.add("Fire");

        List<String> expectedSelectedElements = new ArrayList<>();
        expectedSelectedElements.add("Water");
        expectedSelectedElements.add("Wind");
        Map<String, Boolean> actualElements = new HashMap<>();

        List<String> possibleMetals = new ArrayList<>();
        possibleMetals.add("Gold");
        possibleMetals.add("Silver");
        possibleMetals.add("Bronze");
        possibleMetals.add("Selen");

        boolean metalIsDefined = false;
        String expectedMetal = "Selen";
        String actualMetal = "";

        List<String> possibleColors = new ArrayList<>();
        possibleColors.add("Blue");
        possibleColors.add("Yellow");
        possibleColors.add("Green");
        possibleColors.add("Red");

        boolean colorIsDefined = false;
        String expectedColor = "Yellow";
        String actualColor = "Red";

        List<WebElement> logs = driver.findElements(By.cssSelector("ul.panel-body-list > li"));
        for (WebElement webElement : logs) {
            String[] data = webElement.getText().split(" ");
            if (data[1].equals("Colors:")){
                if (!colorIsDefined){
                    actualColor = data[data.length - 1];
                    colorIsDefined = true;
                }
            } else if (data[1].equals("metal:")){
                if (!metalIsDefined){
                    actualMetal = data[data.length - 1];
                    metalIsDefined = true;
                }
            } else {
                String elementLog = data[1].substring(0, data[1].length() - 1);
                if (!actualElements.containsKey(elementLog)){
                    boolean state = data[data.length - 1].equals("true");
                    actualElements.put(elementLog, state);
                }
            }
        }
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
        for (WebElement element : checkboxes) {
            WebElement checkboxField = element.findElement(By.cssSelector("input[type='checkbox']"));
            String checkBoxText = element.getText();
            assertEquals(checkboxField.isSelected(), actualElements.get(checkBoxText).booleanValue());
        }

        //check radiobutton
        for (WebElement element : radios) {
            if (element.getText().equals(actualMetal)) {
                assertTrue(element.findElement(By.cssSelector("input[type='radio']")).isSelected());
            }
        }

        //check dropdown menu
        assertEquals(color.getFirstSelectedOption().getText(), actualColor);

    }

}
