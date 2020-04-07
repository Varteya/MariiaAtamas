package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 extends BaseTest{

    @Test
    public void testWebDriverSoftAsserts () {

        SoftAssert softAssert = new SoftAssert();

        //Open test site by URL
        String openedURL = openSite();
        softAssert.assertEquals(openedURL, URL);

        //Assert Browser title
        softAssert.assertTrue(homePageIsOpened());

        //Perform login
        softAssert.assertTrue(login());

        //Assert Username is loggined
        softAssert.assertTrue(checkUsername());

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationBarButtons = driver.findElements(By.cssSelector("ul.uui-navigation.nav > li"));

        List<String> navigationBarExpected = new ArrayList<>();
        navigationBarExpected.add("HOME");
        navigationBarExpected.add("CONTACT FORM");
        navigationBarExpected.add("SERVICE");
        navigationBarExpected.add("METALS & COLORS");

        checkTexts(softAssert, navigationBarButtons, navigationBarExpected);

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(benefitIcons.size(), 4);
        for (WebElement element : benefitIcons) {
            softAssert.assertTrue(element.isDisplayed());
        }

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));

        List<String> benefitTextsExpected = new ArrayList<>();
        benefitTextsExpected.add("To include good practices\n" +
                                "and ideas from successful\n" +
                                "EPAM project");
        benefitTextsExpected.add("To be flexible and\n" +
                                "customizable");
        benefitTextsExpected.add("To be multiplatform");
        benefitTextsExpected.add("Already have good base\n" +
                                "(about 20 internal and\n" +
                                "some external projects),\n" +
                                "wish to get more…");
        checkTexts(softAssert, benefitTexts, benefitTextsExpected);

        //Assert that there is the iframe with “Frame Button” exist
        softAssert.assertNotNull(driver.findElement(By.id("frame")));

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertNotNull(driver.switchTo().frame("frame").findElement(By.id("frame-button")));

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSection = driver.findElements(By.cssSelector("ul.sidebar-menu > li"));
        List<String> leftSectionExpected = new ArrayList<>();
        leftSectionExpected.add("Home");
        leftSectionExpected.add("Contact form");
        leftSectionExpected.add("Service");
        leftSectionExpected.add("Metals & Colors");
        leftSectionExpected.add("Elements packs");
        checkTexts(softAssert, leftSection, leftSectionExpected);

        softAssert.assertAll();
    }

    private void checkTexts (SoftAssert softAssert, List<WebElement> actualElements, List<String> expectedElements){
        softAssert.assertEquals(actualElements.size(), expectedElements.size());
        for (WebElement element : actualElements){
            softAssert.assertTrue(element.isDisplayed());
            softAssert.assertTrue(expectedElements.contains(element.getText()));
            expectedElements.remove(element.getText());
        }
        softAssert.assertTrue(expectedElements.isEmpty());
    }
}
