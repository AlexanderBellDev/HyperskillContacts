import java.io.CharArrayWriter;
import java.io.IOException;

class Converter {
    public static char[] convert(String[] words) throws IOException {
        CharArrayWriter writer = new CharArrayWriter();
        for (String word : words) {
            writer.write(word);
        }
        char[] chars = writer.toCharArray();
        writer.close();
        return chars;
    }
}