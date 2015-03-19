/**
 * Created by ben on 3/18/15.
 */


import java.util.HashMap;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class Grader {

    private HashMap<String, Object[]> answerKey = new HashMap<String, Object[]>();
    private Exercises exercises = new Exercises();

    private static int passCount = 0;
    private static int failCount = 0;

    public Grader() {
        // Answer hash keys are methodName|argument so we can test
        // multiple states. This is fragile.
        answerKey.put("HelloName|Ben", new Object[]{
            "", // Helper text for the person grading
            "Hello Ben!" // Expected answer
        });
        answerKey.put("HelloName|Access Code", new Object[]{
            "", // Helper text for the person grading
            "Programming is awesome!" // Expected answer
        });
        answerKey.put("GreaterThan50|51", new Object[]{
            "", // Helper text for the person grading
            true // Expected answer
        });
        answerKey.put("GreaterThan50|50", new Object[]{
            "", // Helper text for the person grading
            false // Expected answer
        });
        answerKey.put("PotatoPotato", new Object[]{
            "", // Helper text for the tester
            "potatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotatopotato" // Expected answer
        });
        answerKey.put("WhileInput", new Object[]{
            "Type a list of words, and a blank line when finished. When testing, use \"horse\", \"battery\", \"staple\".", // Helper text
            "horsebatterystaple" // Expected answer
        });
    }
    // Overloading gradeExercise because some methods don't take arguments
    // For now, maximum one argument for an exercise. Most won't have any.
    // If we need more than one, overload or extend below.
    public void gradeExercise(String methodName) {
        gradeExercise(methodName, null);
    }
    public void gradeExercise(String methodName, Object argument) {
        Method method;
        String key = "";
        String status;
        Object answer = null;
        Object result = null;

        // Handling exceptions like whoa
        try {
            // Print the helper text if input is required so we know what to type to pass
            if(argument != null) {
                key = methodName+"|"+argument;
                System.out.print("running " + methodName + "(" + argument + ") ... ");
                System.out.println(answerKey.get(key)[0]);
                method = exercises.getClass().getDeclaredMethod(methodName, argument.getClass());
                result = method.invoke(exercises, argument);
            } else {
                key = methodName;
                System.out.print("running "+methodName + "() ... ");
                System.out.println(answerKey.get(key)[0]);
                method = exercises.getClass().getMethod(methodName);
                result = method.invoke(exercises);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: IllegalArgumentException. Ask a TA or your teacher about this.\n");
            return;
        } catch (IllegalAccessException e) {
            System.out.println("Error: IllegalAccessException. Ask a TA or your teacher about this.\n");
            return;
        } catch (InvocationTargetException e) {
            System.out.println("Error: InvocationTargetException. Ask a TA or your teacher about this.\n");
            return;
        } catch (SecurityException e) {
            System.out.println("Error: SecurityException. How did you manage that?  Ask a TA or your teacher about this.\n");
            return;
        } catch (NoSuchMethodException e) {
            System.out.println("Error: NoSuchMethodException. Did you change the name of one of the methods?\n");
            return;
        }

        answer = answerKey.get(key)[1];
        // System.out.println("Expecting "+answer+", got "+result);
        boolean passed = false;
        // Use equals to compare string answers, otherwise ==
        if(result.getClass().equals(String.class)) {
            if(result.equals(answer)) {
                passed = true;
            }
        } else {
            if(result == answer) {
                passed = true;
            }
        }

        updateCounts(passed);
        System.out.println((passed ? "Passed" : "Failed")+"\n");
    }

    // Call after all exercises are graded to print a final tally
    public void printTotals() {
        System.out.println(passCount+" passed, "+failCount+" failed.");
    }

    private void updateCounts(boolean pass) {
        if(pass) {
            passCount++;
        } else {
            failCount++;
        }
    }

    private static boolean compareTypes(Object a, Object b) {
        return a.getClass() == b.getClass();
    }
}