package fun.advent.adventclient.model;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Coordinate extends Point implements Comparable<Coordinate> {
    private final Point velocity;

    //"position=< 9,  1> velocity=< 0,  2>"
    public Coordinate(String s) {
        Pattern p = Pattern.compile("position=< ?(-?\\d+), *(-?\\d+)> velocity=< ?(-?\\d+), *(-?\\d+)>");
        Matcher matcher = p.matcher(s);

        if (matcher.matches()) {
            this.x = Integer.parseInt(matcher.group(1));
            this.y = Integer.parseInt(matcher.group(2));
            this.velocity = new Point(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        } else {
            this.velocity = null;
        }
    }

    public void tick() {
        translate(velocity.x, velocity.y);
    }

    @Override
    public int compareTo(Coordinate other) {
        int result = Integer.compare(this.y, other.y);
        if ( result == 0 ) {
            result = Integer.compare(this.x, other.x);
        }
        return result;
    }
}
