package fun.advent.adventclient;

import fun.advent.adventclient.day.five.AlchemicalReduction;
import fun.advent.adventclient.day.seven.TheSumofItsParts;
import fun.advent.adventclient.day.two.InventoryManagementSystem;
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
            String solution = context.getBean(TheSumofItsParts.class).calculateSteps(Files.lines(Paths.get("src/main/resources/day7.txt")));
            System.out.println("the answer is: " + solution);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
