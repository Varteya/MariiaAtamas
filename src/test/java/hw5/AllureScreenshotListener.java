package hw5;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class AllureScreenshotListener extends TestListenerAdapter {

    @Attachment(value = "testScreenshot", type = "image/png", fileExtension = ".png")
    private byte[] takeScreenshot(){
        byte[] array = {1};
        try {
            return ((TakesScreenshot) WebDriverSingleton.INSTANCE.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }


    @Override
    public void onTestSuccess (ITestResult tr){
        super.onTestSuccess(tr);
        takeScreenshot();
    }
    @Override
    public void onTestFailure (ITestResult tr){
        super.onTestFailure(tr);
        takeScreenshot();
    }


}
