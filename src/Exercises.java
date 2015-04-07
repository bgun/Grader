/**
 * Created by ben on 3/18/15.
 */

import java.util.Scanner;
import java.util.HashMap;

public class Exercises {

    // Don't change the method names, return types, or parameters.
    public static String HelloName(String name) {
        /**
         * Exercise 0:
         * Given the above parameter "name", return "Hello <name>!"
         * If the name is "Access Code", return "Programming is awesome!" instead.
         */

        // Write your solution below.
        String greeting = "Hello "+name+"!";
        if(name.equals("Access Code")) {
            greeting = "Programming is awesome!";
        }

        return greeting; // Change this line to return your answer instead of an empty string.
    }

    public static Boolean GreaterThan50(Integer num) {
        /**
         *  Exercise 1:
         *  Given an integer "num":
         *  Return true if num is greater than 50.
         *  Return false if num is less than 50.
         */

        // Write your solution below.
        boolean gt = num > 50;

        return gt; // Change this line to return your answer instead of false.
    }

    public static String PotatoPotato() {
        /**
         *  Exercise 2:
         *  Using a for loop, make a string consisting of the string "potato" repeated
         *  fifteen times, with no spaces. Return the string.
         */

        // Write your solution below.
        String output = "";
        for(int i = 0; i < 15; i++) {
            output += "potato";
        }

        return output; // Change this line to return your answer instead of a blank string.
    }

    public static HashMap<String,String> ReturnHashMapWithOneItem() {
        /**
         *  Exercise 3:
         */

        HashMap<String,String> hm = new HashMap<String,String>();
        hm.put("foo","bar");

        return hm;
    }

    public static void main(String[] args) {
        Grader grader = new Grader();
        grader.run();
        // This line prints the test results at the end.
        System.out.println(grader.printTotals());
    }
}
