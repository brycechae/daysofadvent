package fun.advent.adventclient.day.ten;

import fun.advent.adventclient.model.Coordinate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class TheStarsAlign {

    public void printData(Stream<String> stream) throws InterruptedException, IOException {
        List<Coordinate> cords = stream
                .map(Coordinate::new)
                .collect(Collectors.toList());
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        String s = "";
        Collections.sort(cords);
        for(int j = 0; j < 4; j++) {
            double startX = cords.get(0).getX();
            for (int i = 0; i < cords.size() - 1; i++) {
                Coordinate curr = cords.get(i);
                writer.write(printCords(curr, cords.get(i + 1)));
                if(startX < curr.getX()) {
                    writer.write("\n");
                    startX = curr.getX();
                }
                cords.get(i).tick();
            }

            writer.write("------------> " + j);
            writer.flush();
            Collections.sort(cords);
//
        }
        writer.close();
    }

    private String printCords(Coordinate c1, Coordinate c2) {
        StringBuilder b = new StringBuilder();
        if(c1.getX() >= 0 && c1.getY() >= 0) {
            double dif = c1.getX() - c2.getX();
            for (int i = 0; i < c1.getX(); i++) {
                b.append(".");
            }
            b.append("#");
            for (int i = 0; i < dif; i++) {
                b.append(".");
            }
            b.append("#");
        }
        return b.toString();
    }
}
