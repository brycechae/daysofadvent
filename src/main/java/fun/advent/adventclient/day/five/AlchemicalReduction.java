package fun.advent.adventclient.day.five;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.summingInt;

@Component
public class AlchemicalReduction {
    public int calculatePolymer(Stream<String> lines) {
        List<Character> chars = new ArrayList<Character>();
        String collection = lines.collect(Collectors.joining())
                .chars()
                .mapToObj(e -> (char) e)
                .peek(x -> {
                    chars.add(x);

                        for (int i = 1; i < chars.size(); i++) {
                            char currectChar = chars.get(i);
                            char c = chars.get(i - 1);
                            char upperCase = Character.toUpperCase(c);
                            char lowerCase = Character.toLowerCase(c);
                            if (currectChar == upperCase || currectChar == lowerCase) {
                                System.out.println(chars.toString() + " removing " + c);
                                chars.remove(chars.indexOf(upperCase));
                                chars.remove(chars.indexOf(lowerCase));
                            }
                        }

//                    boolean needsLoop = true;
//                    while(needsLoop) {
//                        int index = chars.indexOf(x);
//                        if(index > 0 && index - 1 < chars.size()) {
//                            char c = chars.get(index - 1);
//                            char upperCase = Character.toUpperCase(c);
//                            char lowerCase = Character.toLowerCase(c);
//                            if (x == upperCase || x == lowerCase) {
//                                chars.remove(chars.indexOf(upperCase));
//                                chars.remove(chars.indexOf(lowerCase));
//                            } else {
//                                needsLoop = false;
//                            }
//                        } else {
//                            needsLoop = false;
//                        }
//                    }
                })
                .map(Object::toString)
                .collect(Collectors.joining());
        System.out.println("Your character array is: " + chars.toString());
        return chars.size();
    }
}
