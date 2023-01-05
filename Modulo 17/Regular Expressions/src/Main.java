import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        challenge11();
    }

    public static void challenge1() {
        // Write the string literal regular expression that will match the following String.
        // Use String.matches() method to verify your answer.

        String challenge1 = "I want a bike.";
        System.out.println(challenge1.matches("I want a bike."));
    }

    public static void challenge2() {
        // Write the string literal regular expression that will match the following Strings.
        // Use String.matches() method to verify your answer.

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";

        String redExp = "I want a b.*";
        System.out.println(challenge1.matches(redExp));
        System.out.println(challenge2.matches(redExp));
    }

    public static void challenge3() {
//        Use Matcher.matches() in the second challenge
        String challenge1 = "I want a bike.";
        String challenge2 = "I want a ball.";
        String regExp = "I want a b\\w+.";

        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(challenge1);
        Matcher matcher2 = pattern.matcher(challenge2);

        System.out.println(matcher.matches());
        System.out.println(matcher2.matches());
    }

    public static void challenge4() {
//        Replace all blanks with underscore
        String challenge4 = "Replace all blanks with underscores.";
        System.out.println(challenge4.replaceAll("\\s", "_"));
    }

    public static void challenge5() {
        String challenge5 = "aaabccccccccdddefffg";
        System.out.println(challenge5.matches("[abcdefg]+"));
        System.out.println(challenge5.matches("[a-g]+"));

    }

    public static void challenge6() {
        String challenge5 = "aaabccccccccdddefffg";
        String match = "a{3}bc{8}d{3}ef{3}g$";
        System.out.println(challenge5.matches(match));
    }

    public static void challenge7() {
        String challenge7 = "abcd.135";
        System.out.println(challenge7.matches("\\D+\\.\\d+"));
        challenge7.matches("^[A-Z][a-z]+\\.\\d+$");

        // Challenge 8
        System.out.println("Challenge 8");
        String challenge8 = "abcd.135ucd.7fdsaf.999";
        String regExp = "[A-Za-z]+\\.(\\d+)";
        Pattern pattern8 = Pattern.compile(regExp);
        Matcher matcher = pattern8.matcher(challenge8);
        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }


    }

    public static void challenge9() {
        // Challenge 9
        System.out.println("Challenge 9");
        String challenge8 = "abcd.135\tuvqz.7\ttzik.999\n";
        String regExp = "[A-Za-z]+\\.(\\d+)\\s";
        Pattern pattern8 = Pattern.compile(regExp);
        Matcher matcher = pattern8.matcher(challenge8);
        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }

        // Challenge 10
        matcher.reset();
        while(matcher.find()) {
            System.out.println("Start: " + matcher.start(1) + " End: " + (matcher.end(1)-1));
        }
    }

    public static void challenge11() {
        // Challenge 11
        System.out.println("Challenge 11");
        String challenge11 = "{0,2}{0,5}{1,3}{2,4}";
        String regExp = "\\{(.+?)\\}";
        Pattern pattern11 = Pattern.compile(regExp);
        Matcher matcher = pattern11.matcher(challenge11);
        while(matcher.find()) {
            System.out.println(matcher.group(1));
        }
    }
}