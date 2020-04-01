package hw1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestingSum extends BaseTest {
    @DataProvider
    public Object[][] longTestData() {
        return new Object[][]{
                {1, 1, 2},
                {0, 0, 0},
                {100, -100, 0},
                {12345, 54321, 66666},
                {-70, -70, -140},
                {-1000000000, -1000000000, -2000000000}
        };
    }

    @Test(groups = {"AddSubTests"}, dataProvider = "longTestData")
    public void testLongs(long a, long b, long expected) {
        doTest(a, b, expected);
    }

    @Override
    protected long operation(long a, long b) {
        return calculator.sum(a, b);
    }

    @DataProvider
    public Object[][] doubleTestData() {
        return new Object[][]{
                {1.5, 1.5, 3},
                {0.0, 0.0001, 0.0001},
                {100.003, -100.003, 0},
                {-12.3333, -4.2222, -16.5555},
                {123.32332, 43.111111, 166.434431},
                {-1000000000.11111111, -1000000000.11111111, -2000000000.22222222}
        };
    }

    @Test(groups = {"AddSubTests"}, dataProvider = "doubleTestData")
    public void testDoubles(double a, double b, double expected) {
        doTest(a, b, expected);
    }

    @Override
    protected double operation (double a, double b) {
        return calculator.sum(a, b);
    }

}
