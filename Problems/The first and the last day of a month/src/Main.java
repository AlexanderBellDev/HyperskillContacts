import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String year = scanner.nextLine();
        String month = scanner.nextLine();

        LocalDate of = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), 1);

        System.out.println(of + " " + YearMonth.from(of).atEndOfMonth());
    }
}