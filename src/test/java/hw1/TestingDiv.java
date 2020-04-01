package hw1;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestingDiv extends  BaseTest{

    @DataProvider
    public Object[][] longTestData () {
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
    public void testLongs (long a, long b, long expected){
        doTest(a, b, expected);
    }

    @Override
    public long operation (long a, long b) {
        return calculator.div(a, b);
    }

    @DataProvider
    public Object[][] doubleTestData () {
        return new Object[][]{
                {1.5, 1.5, 1.0},
                {6.0, 4.0, 1.5},
                {100.003, -1000.0, -0.100003},
                {-12.33, -3.0, 4.11},
                {100.0, 0.5, 200.0},
                {-1000.0003, 0.01, -100000.03}
        };
    }

    @Test(groups = {"MulDivTests"}, dataProvider = "doubleTestData")
    public void testDoubles (double a, double b, double expected) {
        doTest(a, b, expected);
    }

    @Override
    public double operation (double a, double b) {
        return calculator.div(a, b);
    }


    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"MulDivTests"})
    public void checkDivideByZeroLong (){
        calculator.div(100, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class, groups = {"MulDivTests"})
    public void checkDivideByZeroDouble (){
        calculator.div(100.1, 0);
    }

    @AfterMethod
    public void tearDown () {
        calculator = null;
    }
}
