package hw6;

import hw6.BaseStep;
import io.cucumber.java.After;

public class CucumberHooks extends BaseStep {

    @After
    public void tearDown() {
        browser.tearDown();
    }
}
