package fun.advent.adventclient.day.two;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Component
public class InventoryManagementSystem {

    public int generateChecksum(Stream<String> input) {
        Map<String, Set<Integer>> duplicateCount = input.collect(Collectors.toMap(s -> s, this::countDuplicate));

        int numberOfTwos = duplicateCount.entrySet().stream()
                .filter(e -> e.getValue().contains(2))
                .mapToInt(c -> 1)
                .sum();

        int numberOfThrees = duplicateCount.entrySet().stream()
                .filter(e -> e.getValue().contains(3))
                .mapToInt(c -> 1)
                .sum();

        return numberOfTwos * numberOfThrees;
    }

    private Set<Integer> countDuplicate(String s) {
        return new HashSet<>(s.chars()
                .mapToObj(e -> (char) e)
                .collect(groupingBy(e -> e, summingInt(e -> 1)))
                .values());
    }
}
