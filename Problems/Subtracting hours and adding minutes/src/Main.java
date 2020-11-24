import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LocalDateTime parse = LocalDateTime.parse(s);
        int hours, mins;
        hours = scanner.nextInt();
        mins = scanner.nextInt();

        System.out.println(parse.minusHours(hours).plusMinutes(mins));
    }
}