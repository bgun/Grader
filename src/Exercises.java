/**
 * Created by ben on 3/18/15.
 */

import java.util.Scanner;

public class Exercises {

    public static Boolean GreaterThan50(Integer num) {
        /**
         *  Exercise 1:
         *  Given an integer "num":
         *  Return true if num is greater than 50.
         *  Return false if num is less than 50.
         */

        // Write your solution here.

        return false; // Change this line to return your answer instead of false.
    }

    public static String PotatoPotato() {
        /**
         *  Exercise 2:
         *  Using a for loop, build a string consisting of the string "potato" repeated
         *  fifteen times, with no spaces. Return that string.
         */

        // Write your solution here.

        return ""; // Change this line to return your answer instead of a blank string.
    }

    public static String WhileInput() {
        /**
         *  Exercise 3:
         *  Using a while loop, repeatedly accept strings from the user until the user
         *  inputs a blank string. Return a single string that consists of all the user's
         *  input combined into one long string. For example, if I input "horse", "battery",
         *  and "staple", return "horsebatterystaple".
         */

        // Write your solution here.

        return ""; // Change this line to return your answer instead of a blank string.
    }

    public static void main(String[] args) {
        Grader grader = new Grader();

        // Don't modify these lines, but you can comment or uncomment them to
        // grade or skip questions while you test.
        grader.gradeExercise("GreaterThan50",51);
        grader.gradeExercise("GreaterThan50",50);
        grader.gradeExercise("PotatoPotato");
        grader.gradeExercise("WhileInput");

        // This line prints the test results at the end.
        grader.printTotals();
    }
}