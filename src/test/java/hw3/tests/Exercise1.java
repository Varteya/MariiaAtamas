package hw3.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class Exercise1 extends BaseTest {

    @Test
    public void testWebDriverSoftAsserts () {

        SoftAssert softAssert = new SoftAssert();

        //Open test site by URL
        softAssert.assertTrue(openAndCheckSite());

        //Assert Browser title
        softAssert.assertTrue(homePageIsOpened());

        //Perform login
        softAssert.assertTrue(login());

        //Assert Username is loggined
        softAssert.assertTrue(checkUsername());

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> navigationBarExpected = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        softAssert.assertTrue(homePage.navigationBarButtonsAreDisplayed());
        softAssert.assertEquals(homePage.getNavigationBarButtonsTexts(), navigationBarExpected);

        //Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertEquals(homePage.benefitIconsSize(), 4);
        softAssert.assertTrue(homePage.benefitIconsAreDisplayed());

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
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

        softAssert.assertTrue(homePage.benefitTextsAreDisplayed());
        softAssert.assertEquals(homePage.getBenefitTextsTexts(), benefitTextsExpected);

        //Assert that there is the iframe with “Frame Button” exist
        softAssert.assertNotNull(homePage.frameIsExists());

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        homePage.switchToFrame();
        softAssert.assertTrue(homePage.frameButtonIsExists());

        //Switch to original window back
        homePage.switchToHomePage();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> leftSectionExpected = Arrays.asList("Home", "Contact form", "Service",
                                                        "Metals & Colors", "Elements packs");

        softAssert.assertTrue(homePage.leftSectionIsDisplayed());
        softAssert.assertEquals(homePage.getLeftMenuTexts(), leftSectionExpected);

        softAssert.assertAll();
    }

}
