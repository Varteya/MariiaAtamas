package hw9;

import hw9.asserts.SpellerAssertions;
import hw9.service.RestService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

public class EnglishCheckTextTest {

    @Test(description = "Testing one word with a mistake", dataProvider = "oneWordWithMistakeData")
    public void oneWordWithMistake(String[] data) {
        new SpellerAssertions(RestService.getRestService().spellerGetTextEnWithoutOptions(new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @Test(description = "Testing with ignoring URLs", dataProvider = "testWithIgnoringURLs")
    public void ignoringURLs(String[] data) {
        new SpellerAssertions(RestService.getRestService().spellerGetTextWithOptions(RestService.getIgnoreUrls(), new String[]{data[0]}))
                .verifyTextResult(Arrays.asList(Arrays.copyOfRange(data, 1, data.length)));
    }

    @DataProvider
    public Object[][] oneWordWithMistakeData() {
        return new Object[][]{
                {"Feeel", "Feeel"},
                {"Myyyy", "Myyyy"},
                {"Wrth", "Wrth"},
                {"For my father the King and https://www.google.com!", "google", "com"},
                {"https://www.google.com knows what I'm doing.", "google", "com"}
        };
    }

    @DataProvider
    public Object[][] testWithIgnoringURLs() {
        return new Object[][]{
                {"For my father the Kiing and https://www.google.com!", "Kiing"},
                {"https://www.google.com knowss what I'm doing.", "knowss"}
        };
    }

//    @Test(description = "Testing one word with a mistake", dataProvider = "oneWordWithMistakeData")
//    public void oneWordWithMistakeTEXTS(String[] data){
//        new SpellerAssertions(RestService.getRestService().spellerGetTextsEnWithoutOptions(data))
//                .verifyTextsResult(Arrays.asList(Arrays.asList(data)));
//    }

}
