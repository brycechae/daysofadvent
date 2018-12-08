package fun.advent.adventclient.day.seven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TheSumofItsPartsTest {
    @Autowired
    private TheSumofItsParts parts;

    @Test
    public void calculateStepsCalculatesCorrectFirstStep() {
        String expected = "CA";
        Stream<String> testStream = Stream.of("Step C must be finished before step A can begin.");
        String answer = parts.calculateSteps(testStream);
        assertEquals(expected, answer);
    }

    @Test
    public void calculateStepsCalculatesCorrectSecondStep() {
        String expected = "CAF";
        Stream<String> testStream = Stream.of("Step C must be finished before step A can begin.",
                "Step C must be finished before step F can begin.");
        String answer = parts.calculateSteps(testStream);
        assertEquals(expected, answer);
    }
}