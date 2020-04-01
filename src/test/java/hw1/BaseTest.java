package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertEquals;

public abstract class BaseTest {
    protected Calculator calculator;

    @BeforeMethod(groups = {"AddSubTests", "MulDivTests"})
    public void setUp() {
        calculator = new Calculator();
    }

    protected void doTest (long a, long b, long expected) {
        long actual = operation(a, b);
        assertEquals(actual, expected);
    }

    protected abstract long operation(long a, long b);

    protected void doTest (double a, double b, double expected) {
        double actual = operation(a, b);
        assertEquals(actual, expected);
    }

    protected abstract double operation(double a, double b);

    @AfterMethod(groups = {"AddSubTests", "MulDivTests"})
    public void tearDown() {
        calculator = null;
    }
}
