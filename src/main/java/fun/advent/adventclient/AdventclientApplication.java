package fun.advent.adventclient;

import fun.advent.adventclient.day.ten.TheStarsAlign;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class AdventclientApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AdventclientApplication.class, args);
        try {
            context.getBean(TheStarsAlign.class).printData(Files.lines(Paths.get("src/main/resources/day10.txt")));
//            System.out.println("the answer is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
