package hw4.ex2;

import hw4.ex2.pages.MetalsAndColorsPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends BaseTest{

    @DataProvider
    public Object[][] testData (){
        return new Object[][]{
                {TestData.newBuilder().setElements(Arrays.asList("Earth"))
                        .setColors("Yellow")
                        .setMetals("Gold").build()},
                {TestData.newBuilder().setSummary(Arrays.asList("3", "8"))
                        .setVegetables(Arrays.asList("Cucumber", "Tomato")).build()},
                {TestData.newBuilder().setSummary(Arrays.asList("3", "2"))
                        .setElements(Arrays.asList("Wind", "Fire", "Water"))
                        .setMetals("Bronze")
                        .setVegetables(Arrays.asList("Onion")).build()},
                {TestData.newBuilder().setSummary(Arrays.asList("6", "5"))
                        .setElements(Arrays.asList("Water"))
                        .setColors("Green")
                        .setMetals("Selen")
                        .setVegetables(Arrays.asList("All checkboxes")).build()},
                {TestData.newBuilder().setElements(Arrays.asList("Fire"))
                        .setColors("Blue")
                        .setVegetables(Arrays.asList("Cucumber", "Tomato", "Vegetables")).build()}
        };
    }

    @Test(dataProvider = "testData")
    public void metalAndColorsTest(TestData data) {
        //Open test site by URL
        openSite();
        assertTrue(checkURL(firstURL));

        //Perform login
        login();
        assertTrue(isLoggined());

        //Click on the link on the Header section
        goToMetalsAndColors();
        assertTrue(checkURL(secondURL));

        //Fill form on the page
        MetalsAndColorsPage metalsAndColorsPage = browser.getMetalsAndColorsPage();

        List<String> vegetablesValue = data.getVegetables();
        if (vegetablesValue != null && vegetablesValue.equals(Arrays.asList("All checkboxes"))){
            vegetablesValue = metalsAndColorsPage.vegetablesAllValues();
        }

        if (data.getSummary() != null){
            metalsAndColorsPage.setSummaryValues(data.getSummary());
            assertTrue(compareListsWithoutOrder(metalsAndColorsPage.getSummaryValues(), data.getSummary()));
        }
        if (data.getElements() != null){
            metalsAndColorsPage.setElementsTable(data.getElements());
            assertTrue(compareListsWithoutOrder(metalsAndColorsPage.getElementsTable(), data.getElements()));
        }
        if (data.getColors() != null){
            metalsAndColorsPage.setNewColor(data.getColors());
            assertEquals(metalsAndColorsPage.getSelectedColor(), data.getColors());
        }
        if (data.getMetals() != null){
            metalsAndColorsPage.setNewMetal(data.getMetals());
            assertEquals(metalsAndColorsPage.getSelectedMetal(), data.getMetals());
        }
        if (data.getVegetables() != null){
            metalsAndColorsPage.setVegetables(vegetablesValue);
            assertTrue(compareListsWithoutOrder(metalsAndColorsPage.getVegetables(), vegetablesValue));
        }

        metalsAndColorsPage.submit();

        if (data.getSummary() != null){
            int firstAdd = Integer.valueOf(data.getSummary().get(0));
            int secondAdd = Integer.valueOf(data.getSummary().get(1));
            int expectedSum =  secondAdd + firstAdd;
            assertEquals(metalsAndColorsPage.getSummaryResult(), String.valueOf(expectedSum));
        }
        if (data.getElements() != null){
            assertTrue(compareListsWithoutOrder(metalsAndColorsPage.getElementsResult(), data.getElements()));
        }
        if (data.getColors() != null){
            assertEquals(metalsAndColorsPage.getColorResult(), data.getColors());
        }
        if (data.getMetals() != null){
            assertEquals(metalsAndColorsPage.getMetalResult(), data.getMetals());
        }
        if (data.getVegetables() != null){
            assertTrue(compareListsWithoutOrder(metalsAndColorsPage.getVegetablesResult(), vegetablesValue));
        }

    }

    private static boolean compareListsWithoutOrder (List<String> a, List<String> b){
        if (a.size() != b.size()){
            return false;
        }
        for (String s : a){
            if (!b.contains(s)){
                return false;
            }
        }
        return true;
    }

}
