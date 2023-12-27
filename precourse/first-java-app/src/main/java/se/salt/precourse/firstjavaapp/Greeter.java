package se.salt.precourse.firstjavaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;

@SpringBootApplication
public class Greeter implements CommandLineRunner {
  @Autowired
  StartDateHandler startDateHandler;

  private static String greet(String namePassedIn) {
    return "Welcome to SALT, " + namePassedIn;
  }

  public static void main(String[] args) throws IOException, ParseException {
    SpringApplication.run(Greeter.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.print("What is your name? ");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name = reader.readLine();

    System.out.println("When does your course start (yyyy-mm-dd) ?");
    String startDate = reader.readLine();

    boolean isValidDate = false;
    String timeLeft = "";

    while(!isValidDate) {
      if (startDateHandler.dateHasOnlyNumbers(startDate)) {
        isValidDate = true;
        timeLeft = "You start in " + startDateHandler.daysToCourseStart(startDate) + " days!";
      }
      else {
        System.out.println("Please provide a valid date");
        startDate = reader.readLine();
      }
    }
    reader.close();

    String greeting = greet(name);

    System.out.println(greeting);
    System.out.println(timeLeft);
  }
}
