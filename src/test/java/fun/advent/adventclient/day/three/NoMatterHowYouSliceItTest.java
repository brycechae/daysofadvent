package fun.advent.adventclient.day.three;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoMatterHowYouSliceItTest {
    @Autowired
    private NoMatterHowYouSliceIt sliceIt;

    @Test
    public void sliceWorksWithOneExample() {
        int[][] solution = sliceIt.createSlice("#1 @ 1,3: 4x4");
        assertArrayEquals(solution, new int[][]{{1,3}, {5,7}});
    }
}