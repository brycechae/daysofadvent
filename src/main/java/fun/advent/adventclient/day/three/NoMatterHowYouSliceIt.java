package fun.advent.adventclient.day.three;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

@Component
public class NoMatterHowYouSliceIt {


    public int slice(Stream<String> coordinateData) {
        List<String[]> collect = coordinateData
                .map(i -> i.split(" "))
                .collect(Collectors.toList());
        collect.stream().peek(System.out::println);
        return -1;
    }

    public int[][] createSlice(String s) {
        s = s.replaceAll("(#[0-9] @)", "").trim();
        s = s.replaceAll("([,x]|[: ])", " ").trim();
        String[] array = s.split("^/(?!  )( )");

        System.out.println(Arrays.toString(array));
        return null;
    }
}
