import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println(stringBuilder.reverse());
//        int charAsNumber = reader.read();
//        StringBuilder stringBuilder = new StringBuilder();
//        while(charAsNumber != -1) {
//            char character = (char) charAsNumber;
//            stringBuilder.append(character);
//            charAsNumber = reader.read();
//        }
//        stringBuilder.reverse();
//        System.out.println(stringBuilder.toString());
        reader.close();
    }
}