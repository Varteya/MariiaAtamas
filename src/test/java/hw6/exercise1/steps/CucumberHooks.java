package hw6.exercise1.steps;

import io.cucumber.java.After;

public class CucumberHooks extends BaseStep {

    @After
    public void tearDown() {
        browser.tearDown();
    }
}
