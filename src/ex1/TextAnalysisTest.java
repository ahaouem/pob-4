package ex1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

public class TextAnalysisTest {

    @Test
    public void testWordCount() {
        String text = "To jest przykładowy tekst do analizy. To jest przykład.";
        long expected = 9;
        long actual = TextAnalysis.getWordCount(text);
        assertEquals(expected, actual);
    }

    @Test
    public void testUniqueWordCount() {
        String text = "To jest przykładowy tekst do analizy. To jest przykład.";
        long expected = 7;
        long actual = TextAnalysis.getUniqueWordCount(text);
        assertEquals(expected, actual);
    }

    @Test
    public void testAverageWordLength() {
        String text = "To jest przykładowy tekst do analizy.";
        double expected = 5.0;
        double actual = TextAnalysis.getAverageWordLength(text);
        assertEquals(expected, actual, 0.17);
    }

    @Test
    public void testLongestWord() {
        String text = "To jest przykładowy tekst do analizy.";
        String expected = "przykładowy";
        String actual = TextAnalysis.getLongestWord(text);
        assertEquals(expected, actual);
    }

    @Test
    public void testMostFrequentWord() {
        String text = "To jest tekst tekst tekst.";
        String expected = "tekst";
        String actual = TextAnalysis.getMostFrequentWord(text);
        assertEquals(expected, actual);
    }

    @Test
    public void testWordFrequency() {
        String text = "To jest tekst tekst tekst.";
        Map<String, Long> expected = Map.of("To", 1L, "jest", 1L, "tekst", 3L);
        Map<String, Long> actual = TextAnalysis.getWordFrequency(text);
        assertEquals(expected, actual);
    }
}
