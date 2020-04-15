package hw5;

import hw5.steps.Exercise1steps;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class BrokenTest extends BaseTest {

    Exercise1steps steps;

    @Feature("Home Page testing")
    @Story("Broken test")
    @Test
    public void brokenTest (){

        steps = new Exercise1steps(browser);

        steps.openSite(URL);
        steps.checkURL(URL);
        steps.checkHeader("Something else");
        steps.login(login, password);
        steps.checkUsername(username);

    }
}
