package hw5;

import hw5.steps.Exercise2steps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.*;


@Listeners({AllureScreenshotListener.class})
public class Exercise2 extends BaseTest {

    private Exercise2steps steps;

    @Feature("Different Elements testing")
    @Story("Checking elements on the page")
    @Test
    public void testDifferentElements() {

        steps = new Exercise2steps(browser);

        List<String> expectedSelectedElements = Arrays.asList("Water", "Wind");
        String expectedMetal = "Selen";
        String expectedColor = "Yellow";

        steps.openSite(URL);
        steps.checkURL(URL);
        steps.checkHeader("Home Page");
        steps.login(login, password);
        steps.checkUsername(username);
        steps.openDifferentElements();
        steps.selectCheckboxes(expectedSelectedElements);
        steps.selectRadios(expectedMetal);
        steps.selectColor(expectedColor);
        steps.parseLogs();
        steps.checkActualColor();
        steps.checkActualMetal();
        steps.checkActualElements();
        steps.checkLoggedColor();
        steps.checkLoggedMetal();
        steps.checkLoggedElements();

    }
}