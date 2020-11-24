import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.withYear(Math.max(dateTime1.getYear(), dateTime2.getYear()));
        localDateTime = localDateTime.withMonth(Math.max(dateTime1.getMonthValue(), dateTime2.getMonthValue()));
        localDateTime = localDateTime.withDayOfMonth(Math.max(dateTime1.getDayOfMonth(), dateTime2.getDayOfMonth()));
        localDateTime = localDateTime.withHour(Math.max(dateTime1.getHour(), dateTime2.getHour()));
        localDateTime = localDateTime.withMinute(Math.max(dateTime1.getMinute(), dateTime2.getMinute()));
        localDateTime = localDateTime.withSecond(Math.max(dateTime1.getSecond(), dateTime2.getSecond()));
        localDateTime = localDateTime.withNano(0);
        return localDateTime;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        File sampleFile = new File("sample.txt");
        byte[] content = new byte[] {'J', 'a', 'v', 'a'};

        try {
            OutputStream outputStream = new FileOutputStream(sampleFile,true);
            outputStream.write(content);
            outputStream.close();
        } catch (Exception e) {
            System.out.println("Error!");
        }

//        final Scanner scanner = new Scanner(System.in);
//        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
//        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
//        System.out.println(merge(firstDateTime, secondDateTime));
    }
}