package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Exercise1 extends BaseTest{

    @Test
    public void testWebDriver () {

        SoftAssert softAssert = new SoftAssert();

        //Open test site by URL
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        softAssert.assertEquals(driver.getCurrentUrl(), "https://jdi-testing.github.io/jdi-light/index.html");

        //Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");

        //Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();
        softAssert.assertTrue(driver.findElement(By.cssSelector(".logout")).isDisplayed());

        //Assert Username is loggined
        softAssert.assertEquals(driver.findElement(By.id("user-name")).getText(), "ROMAN IOVLEV");

        //Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationBarButtons = driver.findElements(By.cssSelector("ul.uui-navigation > li"));
        softAssert.assertEquals(navigationBarButtons.size(), 5);
        for (WebElement element : navigationBarButtons){
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(navigationBarButtons.get(0).getText(), "HOME");
        softAssert.assertEquals(navigationBarButtons.get(1).getText(), "CONTACT FORM");
        softAssert.assertEquals(navigationBarButtons.get(2).getText(), "SERVICE");
        softAssert.assertEquals(navigationBarButtons.get(3).getText(), "METALS & COLORS");

        //Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> benefitIcons = driver.findElements(By.className("benefit-icon"));
        softAssert.assertEquals(benefitIcons.size(), 4);
        for (WebElement element : benefitIcons) {
            softAssert.assertTrue(element.isDisplayed());
        }

        //Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefitTexts = driver.findElements(By.className("benefit-txt"));
        for (WebElement element : benefitTexts) {
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(benefitTexts.get(0).getText(), "To include good practices\n" +
                                                                         "and ideas from successful\n" +
                                                                         "EPAM project");
        softAssert.assertEquals(benefitTexts.get(1).getText(), "To be flexible and\n" +
                                                                         "customizable");
        softAssert.assertEquals(benefitTexts.get(2).getText(),"To be multiplatform");
        softAssert.assertEquals(benefitTexts.get(3).getText(), "Already have good base\n" +
                                                                         "(about 20 internal and\n" +
                                                                         "some external projects),\n" +
                                                                         "wish to get more…");

        //Assert that there is the iframe with “Frame Button” exist
        softAssert.assertNotNull(driver.findElement(By.id("frame")));

        //Switch to the iframe and check that there is “Frame Button” in the iframe
        softAssert.assertNotNull(driver.switchTo().frame("frame").findElement(By.id("frame-button")));

        //Switch to original window back
        driver.switchTo().defaultContent();

        //Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<WebElement> leftSection = driver.findElements(By.cssSelector("ul.sidebar-menu > li"));
        for (WebElement element : leftSection){
            softAssert.assertTrue(element.isDisplayed());
        }
        softAssert.assertEquals(leftSection.get(0).getText(), "Home");
        softAssert.assertEquals(leftSection.get(1).getText(), "Contact form");
        softAssert.assertEquals(leftSection.get(2).getText(), "Service");
        softAssert.assertEquals(leftSection.get(3).getText(), "Metals & Colors");
        softAssert.assertEquals(leftSection.get(4).getText(), "Elements packs");

        softAssert.assertAll();
    }
}
