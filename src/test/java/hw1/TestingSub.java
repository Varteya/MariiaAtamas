package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestingSub {
    private Calculator calculator;

    @BeforeMethod
    public void setUp () {
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] longTestData () {
        return new Object[][]{
                {1, 1, 0},
                {0, 1000, -1000},
                {100, -100, 200},
                {-12345, 54321, -66666},
                {-70, -70, 0},
                {1000000000, -1000000000, 2000000000}
        };
    }

    @Test(groups = {"AddSubTests"}, dataProvider = "longTestData")
    public void testLongs (long firstAdd, long secondAdd, long expected){
        long actual = calculator.sub(firstAdd, secondAdd);
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] doubleTestData () {
        return new Object[][]{
                {1.5, 1.5, 0},
                {0.0, 0.0001, -0.0001},
                {100.003, -100.003, 200.006},
                {-12.3333, 4.2222, -16.5555},
                {123.32332, -43.111111, 166.434431},
                {-1000000000.11111111, 1000000000.11111111, -2000000000.22222222}
        };
    }

    @Test(groups = {"AddSubTests"}, dataProvider = "doubleTestData")
    public void testDoubles (double firstAdd, double secondAdd, double expected) {
        double actual = calculator.sub(firstAdd, secondAdd);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown () {
        calculator = null;
    }
}
