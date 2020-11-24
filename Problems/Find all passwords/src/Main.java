import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern.compile("password[\\s:]*(\\w+)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        List<String> passwords = new ArrayList<>();
        while (matcher.find()) {
            passwords.add(matcher.group(1));
        }

        if(!passwords.isEmpty()){
            passwords.forEach(System.out::println);
        }else {
            System.out.println("No passwords found.");
        }




//        if (matcher.find()) {
//
//        } else {
//
//        }

    }
}