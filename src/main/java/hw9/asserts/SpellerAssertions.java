package hw9.asserts;


import hw9.dto.SpellerDTO;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class SpellerAssertions {

    private SpellerDTO[] spellerTextResult;
    private SpellerDTO[][] spellerTextsResult;

    public SpellerAssertions(SpellerDTO[] response) {
        this.spellerTextResult = response;
    }

    public SpellerAssertions(SpellerDTO[][] response) {
        this.spellerTextsResult = response;
    }

    public void verifyTextResult(List<String> expectedMistakes) {
        List<String> actualMistakes = new ArrayList<>();
        for (SpellerDTO result : spellerTextResult) {
            actualMistakes.add(result.getWord());
        }
        assertTrue(expectedMistakes.containsAll(actualMistakes)
                && actualMistakes.containsAll(expectedMistakes));
    }

    public void verifyTextsResult(List<List<String>> expectedMistakes) {
        for (int i = 0; i < spellerTextsResult.length; i++) {
            List<String> actualMistakes = new ArrayList<>();
            for (SpellerDTO result : spellerTextsResult[i]) {
                actualMistakes.add(result.getWord());
            }
            assertTrue(expectedMistakes.get(i).containsAll(actualMistakes)
                    && actualMistakes.containsAll(expectedMistakes.get(i)));
        }
    }

}
