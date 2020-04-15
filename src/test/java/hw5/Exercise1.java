package hw5;

import hw5.steps.Exercise1steps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise1 extends BaseTest {

    Exercise1steps steps;

    @Feature("Home Page testing")
    @Story("Checking elements on the page")
    @Test
    public void exerciseOneTest (){

        steps = new Exercise1steps(browser);

        steps.openSite(URL);
        steps.checkURL(URL);
        steps.checkHeader("Home Page");
        steps.login(login, password);
        steps.checkUsername(username);
        steps.assertHeaderElements();
        steps.assertImages();
        steps.assertBenefitTexts();
        steps.assertFrameWithButton();
        steps.switchToTheIframe();
        steps.checkFrameButton();
        steps.switchToHomePage();
        steps.assertLeftSection();
    }
}