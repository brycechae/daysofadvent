package fun.advent.adventclient.day.two;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class InventoryManagementSystemTest {

    @Autowired
    private InventoryManagementSystem inventory;

    private static final Stream<String> TEST_STREAM = Stream.of(
            "abcdef",
            "bababc",
            "abbcde",
            "abcccd",
            "aabcdd",
            "abcdee",
            "ababab"

    );

    @Test
    public void generateChecksumCorrectlyGeneratesIfNoRepeatingNumbers() {
        int solution = inventory.generateChecksum(Stream.of("abcdef"));
        assertThat(solution, equalTo(0));
    }

    @Test
    public void generateChecksumCorrectlyGeneratesIfTwoAndThreeRepeats() {
        int solution = inventory.generateChecksum(Stream.of(
                "bababc"));
        assertThat(solution, equalTo(1));
    }

    @Test
    public void generateChecksumCorrectlyGeneratesIfTwoRepeats() {
        int solution = inventory.generateChecksum(Stream.of(
                "abbcde", "abcdee", "aabcdd"));
        assertThat(solution, equalTo(0));
    }

    @Test
    public void generateChecksumCorrectlyGeneratesIfThreeRepeats() {
        int solution = inventory.generateChecksum(Stream.of(
                "ababab"));
        assertThat(solution, equalTo(0));
    }

    @Test
    public void generatesChecksumCorrectly() {
        int solution = inventory.generateChecksum(TEST_STREAM);
        assertThat(solution, equalTo(12));
    }
}