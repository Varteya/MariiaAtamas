package hw9;

import hw9.asserts.SpellerAssertions;
import hw9.asserts.SpellerTextsAssertion;
import hw9.service.RestService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EnglishCheckTextTest extends BaseTest {

    @Test(description = "Testing one word with a mistake", dataProvider = "oneWordWithMistakeData")
    public void oneWordWithMistake(String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextEnWithoutOptions(data))
                .verifyTextResult(Arrays.asList(data));
    }


    @Test(description = "Testing one word with a mistake", dataProvider = "oneWordWithMistakeData")
    public void oneWordWithMistakeTEXTS(String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextsEnWithoutOptions(data))
                .verifyTextsResult(Arrays.asList(Arrays.asList(data)));
    }

    @Test(description = "Testing with ignoring URLs", dataProvider = "testWithIgnoringURLs")
    public void ignoringURLs(String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(IGNORE_URLS, new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing without ignoring URLs", dataProvider = "testWithoutIgnoringURLs")
    public void findingURLs(String[] data){
        new SpellerAssertions(RestService.getRestService().spellerGetTextEnWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @DataProvider
    public Object[][] oneWordWithMistakeData() {
        return new Object[][]{
                {"Feeel"},
                {"Myyyy"},
                {"Wrth"}
        };
    }

    @DataProvider
    public Object[][] testWithIgnoringURLs(){
        return new Object[][]{
                {"For my father the Kiing and https://www.google.com!", "Kiing"},
                {"https://www.google.com knowss what I'm doing.", "knowss"}
        };
    }

    @DataProvider
    public Object[][] testWithoutIgnoringURLs(){
        return new Object[][]{
                {"For my father the King and https://www.google.com!", "google", "com"},
                {"https://www.google.com knows what I'm doing.", "google", "com"}
        };
    }

}
