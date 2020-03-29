package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestingMul {
    private Calculator calculator;

    @BeforeMethod
    public void setUp () {
        calculator = new Calculator();
    }

    @DataProvider
    public static Object[][] longTestData () {
        return new Object[][]{
                {1, 1, 1},
                {0, 10000, 0},
                {100, -100, -10000},
                {55, 2, 110},
                {-70, -70, 4900},
                {-10000, -70000, 700000000}
        };
    }

    @Test(groups = {"MulDivTests"}, dataProvider = "longTestData")
    public void testLongs (long firstAdd, long secondAdd, long expected){
        long actual = calculator.mult(firstAdd, secondAdd);
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] doubleTestData () {
        return new Object[][]{
                {1.5, 1.5, 2.25},
                {0.0, 0.0001, 0.0},
                {100.003, -1000.0, -100003.0},
                {-12.3333, -1.0, 12.3333},
                {100.0, 0.5, 50.0},
                {-1000111.11, 5.0, -5000555.55}
        };
    }

    @Test(groups = {"MulDivTests"}, dataProvider = "doubleTestData")
    public void testDoubles (double firstAdd, double secondAdd, double expected) {
        double actual = calculator.mult(firstAdd, secondAdd);
        assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown () {
        calculator = null;
    }
}
