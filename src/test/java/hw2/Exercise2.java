package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
        for (WebElement element : checkboxes) {
            WebElement checkboxField = element.findElement(By.cssSelector("input[type='checkbox']"));
            if (element.getText().equals("Wind") || element.getText().equals("Water")) {
                assertTrue(checkboxField.isSelected());
            } else {
                assertFalse(checkboxField.isSelected());
            }
        }

        //Select radio
        List<WebElement> radios = driver.findElements(By.cssSelector("div.checkbox-row > label.label-radio"));
        for (WebElement element : radios) {
            if (element.getText().equals("Selen")) {
                element.click();
            }
        }
        for (WebElement element : radios) {
            if (element.getText().equals("Selen")) {
                assertTrue(element.findElement(By.cssSelector("input[type='radio']")).isSelected());
            }
        }

        //Select in dropdown
        Select color = new Select(driver.findElement(By.cssSelector("select.uui-form-element")));
        color.selectByVisibleText("Yellow");
        assertEquals(color.getFirstSelectedOption().getText(), "Yellow");

        //Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value.

        List<String> correctLogs = new ArrayList<>();
        correctLogs.add("metal: value changed to Selen");
        correctLogs.add("Wind: condition changed to true");
        correctLogs.add("Water: condition changed to true");
        correctLogs.add("Colors: value changed to Yellow");
        List<WebElement> logs = driver.findElements(By.cssSelector("ul.panel-body-list > li"));
        for (WebElement element : logs) {
            String logStringWithoutTime = element.getText().substring(9);
            assertTrue(correctLogs.contains(logStringWithoutTime));
        }

    }

}
