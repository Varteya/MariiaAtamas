package hw5.steps;

import hw5.Browser;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertNotNull;


public class Exercise1steps extends BaseSteps {

    public Exercise1steps (Browser browser){
        super(browser);
    }

    @Step("Assert header items")
    public void assertHeaderElements(){
        List<String> navigationBarExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        assertTrue(homePage.navigationBarButtonsAreDisplayed());
        assertEquals(homePage.getNavigationBarButtonsTexts(), navigationBarExpected);
    }

    @Step("Assert images on index page")
    public void assertImages() {
        assertEquals(homePage.benefitIconsSize(), 4);
        assertTrue(homePage.benefitIconsAreDisplayed());
    }

    @Step("Assert benefit texts")
    public void assertBenefitTexts() {
        List<String> benefitTextsExpected = Arrays.asList("To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project",

                "To be flexible and\n" +
                        "customizable",

                "To be multiplatform",

                "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…");
        assertTrue(homePage.benefitTextsAreDisplayed());
        assertEquals(homePage.getBenefitTextsTexts(), benefitTextsExpected);
    }

    @Step("Assert frame with Frame Button is exists")
    public void assertFrameWithButton (){
        assertNotNull(homePage.frameIsExists());
    }

    @Step("Switch to the iframe")
    public void switchToTheIframe (){
        homePage.switchToFrame();
    }

    @Step("Check that there is “Frame Button” in the iframe")
    public void checkFrameButton() {
        assertTrue(homePage.frameButtonIsExists());
    }

    @Step("Switch to original window back")
    public void switchToHomePage() {
        homePage.switchToHomePage();
    }

    @Step("Assert items in the left section")
    public void assertLeftSection (){
        List<String> leftSectionExpected = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");

        assertTrue(homePage.leftSectionIsDisplayed());
        assertEquals(homePage.getLeftMenuTexts(), leftSectionExpected);
    }

}
