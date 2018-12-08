package fun.advent.adventclient.day.seven;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class TheSumofItsParts {


    public String calculateSteps(Stream<String> stream) {
        Pattern p = Pattern.compile("Step ([A-Z]) [a-z ]+ ([A-Z]) [a-z ]+.");
        List<String> count = stream
                .map(p::matcher)
                .filter(Matcher::matches)
                .map(m -> m.group(1) + "," + m.group(2))
        .collect(Collectors.toList());



        String solution = count.stream()
                .peek(System.out::println)
                .map(i -> String.join("", i))
                .collect(Collectors.joining());
        return solution;
    }
}
