package fun.advent.adventclient.day.five;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlchemicalReductionTest {

    @Autowired
    AlchemicalReduction reduction;

    @Test
    public void calculatePolymerDestroysOnCorrectSingeSequence() {
        Stream<String> wordStream = Stream.of("aA");

        int solution = reduction.calculatePolymer(wordStream);

        assertThat(solution, equalTo(0));
    }

    @Test
    public void calculatePolymerDestroysOnCorrectTwoSequence() {
        Stream<String> wordStream = Stream.of("abBA");

        int solution = reduction.calculatePolymer(wordStream);

        assertThat(solution, equalTo(0));
    }

    @Test
    public void calculatePolymerRetainsIfNoMatching() {
        Stream<String> wordStream = Stream.of("abAB", "aabAAB");

        int solution = reduction.calculatePolymer(wordStream);

        assertThat(solution, equalTo(10));
    }

    @Test
    public void calculatePolymerDestroysOnCorrectSequence() {
        Stream<String> wordStream = Stream.of("dabAcCaCBAcCcaDA");

        int solution = reduction.calculatePolymer(wordStream);

        assertThat(solution, equalTo(10));
    }
}