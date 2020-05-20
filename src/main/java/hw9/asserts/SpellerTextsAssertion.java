package hw9.asserts;

import hw9.dto.SpellerDTO;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class SpellerTextsAssertion {

    private SpellerDTO[][] spellerTextsResult;

    public SpellerTextsAssertion (SpellerDTO[][] response){
        this.spellerTextsResult = response;
    }


    public void verifyTextsResult (List<List<String>> expectedMistakes) {
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
