package hw4.ex2;

import org.testng.annotations.DataProvider;

import java.util.Arrays;

public class TestDataProvider {

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
}
