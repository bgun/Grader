/**
 * Created by ben on 3/18/15.
 */


import java.util.HashMap;

public class Grader {

    private static int passCount = 0;
    private static int failCount = 0;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";

    private HashMap<String, Object> answerKey = new HashMap<String, Object>();

    public Grader() {
        answerKey.put("GreaterThan50",  true);
        answerKey.put("PotatoPotato",  "potatopotatopotatopotatopotato");
        answerKey.put("WhileInput",    "horsebatterystaple");

        System.out.println("\nStarting grader.\n");
    }
    private void updateCounts(boolean pass) {
       if(pass) {
           passCount++;
       } else {
           failCount++;
       }
    }
    public void gradeExercise(String methodName, Object result) {
        boolean passed = false;
        String status;
        Object answer = answerKey.get(methodName);

        // Use #equals to compare string answers
        if(result.getClass().equals(String.class)) {
            if(result.equals(answer)) {
                passed = true;
            }
        } else {
            if(result == answer) {
                passed = true;
            }
        }

        status = passed ? "Passed\n" : "Failed\n";
        updateCounts(passed);
        System.out.println(methodName+": "+status);
    }
    public void printTotals() {
        System.out.println(passCount+" passed, "+failCount+" failed.");
    }
    public static boolean compareTypes(Object a, Object b) {
        return a.getClass() == b.getClass();
    }
}