import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        part = part.toLowerCase();
        String line = scanner.nextLine();
        line = line.toLowerCase();
        Pattern pattern = Pattern.compile("\\B" + part + "\\B");
        Matcher matcher = pattern.matcher(line);
        System.out.println(matcher.find() ? "YES" : "NO");

        // write your code here
    }
}