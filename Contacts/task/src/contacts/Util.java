package contacts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static boolean isValid(String phoneNumber) {
        boolean valid = true;
        String[] groups = phoneNumber.split("[-\\s]");
        Pattern pattern = Pattern.compile("\\+?[0-9A-Za-z()]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(groups[0]);
        boolean containsValidBrackets = true;
        if (matcher.matches()) {
            int numberOfBracketGroups = 0;
            for (int i = 0; i < groups.length; i++) {
                pattern = Pattern.compile("\\(\\S*?\\)", Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(groups[i]);
                if (matcher.find()) {
                    pattern = Pattern.compile("\\+?\\(([^)]+)\\)", Pattern.CASE_INSENSITIVE);
                    matcher = pattern.matcher(groups[i]);
                    if (!matcher.matches()) {
                        valid = false;
                        break;
                    }
                    numberOfBracketGroups++;
                }else if(groups[i].contains("(") || groups[i].contains(")")){
                    valid = false;
                }

                if (numberOfBracketGroups > 1) {
                    valid = false;
                }
            }
            if (valid) {
                for (int i = 1; i < groups.length; i++) {
                    pattern = Pattern.compile("[0-9A-Za-z]{2,}", Pattern.CASE_INSENSITIVE);
                    matcher = pattern.matcher(groups[i]);
                    if (!matcher.find()) {
                        valid = false;
                    }
                }
            }
        } else {
            valid = false;
        }
        return valid;
    }
}
