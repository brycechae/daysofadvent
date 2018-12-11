package fun.advent.adventclient.day.ten;

import fun.advent.adventclient.model.Coordinate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;

import static junit.framework.TestCase.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CoordinateTest {


    @Test
    public void buildCoordinates() {
        String coordinatePair = "position=< 9,  1> velocity=< 0,  2>";
        Coordinate expected = new Coordinate();
        expected.move(9, 1);
        Coordinate c = new Coordinate(coordinatePair);
        assertEquals(expected.getX(), c.getX());
        assertEquals(expected.getY(), c.getY());
    }

    @Test
    public void tickCorrectlyCalculates() {
        String coordinatePair = "position=< 9,  1> velocity=< 0,  2>";
        Point expected = new Point(9, 3);
        Coordinate c = new Coordinate(coordinatePair);
        c.tick();

        assertEquals(expected.getX(), c.getX());
        assertEquals(expected.getY(), c.getY());
    }
}