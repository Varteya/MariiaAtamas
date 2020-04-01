package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestingMul extends BaseTest {

    @DataProvider
    public Object[][] longTestData () {
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
    public void testLongs (long a, long b, long expected){
        doTest(a, b, expected);
    }

    @Override
    public long operation (long a, long b) {
        return calculator.mult(a, b);
    }

    @DataProvider
    public Object[][] doubleTestData () {
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
    public void testDoubles (double a, double b, double expected) {
        doTest(a, b, expected);
    }

    @Override
    public double operation (double a, double b) {
        return calculator.mult(a, b);
    }
}
