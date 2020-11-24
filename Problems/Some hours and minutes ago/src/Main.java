
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String time1 = scanner.nextLine();
        LocalTime time1Time = LocalTime.parse(time1);
        String time2 = scanner.nextLine();
        LocalTime time2Time = LocalTime.parse(time2);
        System.out.println(Math.abs(time1Time.toSecondOfDay() - time2Time.toSecondOfDay()));
    }
}