package hw4.ex2;

import hw4.ex2.pages.MetalsAndColorsPage;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class Exercise2 extends TestImplementation {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "testData")
    public void metalAndColorsTest(TestData data) {
        //Open test site by URL
        openSite(firstURL);
        assertTrue(checkURL(firstURL));

        //Perform login
        login(login, password);
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
