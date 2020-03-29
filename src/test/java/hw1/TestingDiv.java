package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestingDiv {
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
                {100, -100, -1},
                {55, 2, 27},
                {-70, -70, 1},
                {-10000, -70000, 0}
        };
    }

    @Test(groups = {"MulDivTests"}, dataProvider = "longTestData")
    public void testLongs (long firstAdd, long secondAdd, long expected){
        long actual = calculator.div(firstAdd, secondAdd);
        assertEquals(actual, expected);
    }

    @DataProvider
    public static Object[][] doubleTestData () {
        return new Object[][]{
                {1.5, 1.5, 1.0},
                {6.0, 4.0, 1.5},
                {100.003, -1000.0, -100003.0},
                {-12.3333, -3.0, 4.1111},
                {100.0, 0.5, 200.0},
                {-1000.0003, 0.01, -100000.03}
        };
    }

    @Test(groups = {"MulDivTests"}, dataProvider = "doubleTestData")
    public void testDoubles (double firstAdd, double secondAdd, double expected) {
        double actual = calculator.div(firstAdd, secondAdd);
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = {"MulDivTests"})
    public void checkDivideByZeroLong (){
        calculator.div(100, 0);
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = {"MulDivTests"})
    public void checkDivideByZeroDouble (){
        calculator.div(100.1, 0);
    }

    @AfterMethod
    public void tearDown () {
        calculator = null;
    }
}
