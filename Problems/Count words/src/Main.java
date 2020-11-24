import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if(!s.isBlank()){
            String[] s1 = s.trim().split("\\s+");
            System.out.println(s1.length);
        }else {
            System.out.println("0");
        }

        reader.close();
    }
}