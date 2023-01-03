import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Write the following anonymous class as a lambda expression:
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
//                    System.out.println(part);
                }
            }
        };
        // Solution
        runnable = () -> {
            String s = "Let's split this up into an array";
            String[] parts = s.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        runnable.run();

        // Solution 2
        Function<String, String> lambdaFunction = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i%2 == 1){
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // Solution 3 Execute the last Function
        lambdaFunction.apply("1234567890");

        // Solution 5
        System.out.println(everySecondCharacter(lambdaFunction, "1234567890"));

        // Challenge 6
        Supplier<String> iLoveJava = () -> {
            return "I love Java!";
        };

        // Challenge 7
        String supplierResult = iLoveJava.get();
        System.out.println(supplierResult);

        // Challenge 8 - 9 - 10
        List<String> topName2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        Function<String, String> firstUpper = (String s) -> {
            return s.substring(0,1).toUpperCase().concat(s.substring(1));
        };

        topName2015.stream()
                .map(name -> name.substring(0,1).toUpperCase() + name.substring(1))
                .peek(System.out::println)
                .sorted()
                .forEach(System.out::println);

    }

    // Challenge 2
    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i%2 == 1){
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    // Challenge 4
    public static String everySecondCharacter(Function<String, String> lambdaFunction, String s) {
        return lambdaFunction.apply(s);
    }



}
