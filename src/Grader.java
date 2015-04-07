/**
 * Created by ben on 3/18/15.
 */


public class Grader {

    private static int passCount = 0;
    private static int failCount = 0;

    public void test(Object result, Object expected) {
        try {
            expected.equals(result);
            passCount++;
        } catch(AssertionError ae) {
            failCount++;
        }
    }

    public void run() {
        //   Run the exercise                 // Expected answer
        test(Exercises.HelloName("Ben"), "Hello, Ben!");
        test(Exercises.HelloName("Access Code"), "Programming is awesome!");
        test(Exercises.GreaterThan50(51), true);
        test(Exercises.GreaterThan50(50),         false);
        test(Exercises.PotatoPotato(),           "potatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotato");
        test(Exercises.WhileInput(),             "horsebatterystaple");
    }

    // Call after all exercises are graded to print a final tally
    public String printTotals() {
        return passCount+" passed, "+failCount+" failed.";
    }
}
