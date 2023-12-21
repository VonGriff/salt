package se.salt.precourse.firstjavaapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.util.Date;

public class Greeter {
  private static String greet(String namePassedIn) {
    return "Welcome to SALT, " + namePassedIn;
  }

  private static String start(Date date) {
    Date today = new Date();
    long days = (date.getTime() - today.getTime()) / 1000 / 60 / 60 / 24;

    return "Today it is " + days + " days left until the course starts";
  }

  public static void main(String[] args) throws IOException, ParseException {
    System.out.print("What is your name? ");

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name = reader.readLine();

    System.out.println("When does your course start (yyyy-mm-dd) ?");
    String startDate = reader.readLine();

    StartDateHandler startDateHandler = new StartDateHandler();

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

    //Date course = DateFormat.getDateInstance().parse(startDate);
    //Date course = DateFormat.getDateInstance().parse(reader.readLine());

    String greeting = greet(name);
    //long timeLeft = startDateHandler.daysToCourseStart(startDate);

    System.out.println(greeting);
    System.out.println(timeLeft);
  }
}
