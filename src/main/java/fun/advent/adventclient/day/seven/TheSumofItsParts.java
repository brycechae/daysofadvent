package fun.advent.adventclient.day.seven;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Component
public class TheSumofItsParts {


    public String calculateSteps(Stream<String> stream) {
        Pattern p = Pattern.compile("Step ([A-Z]) [a-z ]+ ([A-Z]) [a-z ]+.");
        Map<String, List<String>> count = stream
                .map(p::matcher)
                .filter(Matcher::matches)
                .map(Matcher::toMatchResult)
                .collect(Collectors.toMap((m) -> m.group(1), m -> {
                    List<String> list = new ArrayList<>();
                    list.add(m.group(2));
                    return list;
                }, (left, right) -> {
                    left.addAll(right);
                    return left;
                }, LinkedHashMap::new));


        for(String s : count.keySet()) {
            Collections.sort(count.get(s));
        }

        String memoryBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] keys =  count.keySet().toArray(new String[count.keySet().size()]);
        Set<String> completed = new LinkedHashSet<>();

        for (int i = 0; i < keys.length; i++) {
            String keyAtIndex = keys[i];
            List<String> ruleData = count.get(keyAtIndex);
            completed.add(keyAtIndex);

            for(int alphabet = 0; alphabet < memoryBank.length(); alphabet++) {

            }
        }
        String solution = count.toString();
        return solution;
    }

}
