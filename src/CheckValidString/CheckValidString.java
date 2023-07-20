package CheckValidString;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CheckValidString {

    public static List<String> OPEN_BRACKETS = Arrays.asList("(", "{", "[");
    public static List<String> CLOSE_BRACKETS = Arrays.asList(")", "}", "]");

    public CheckValidString(String s) throws Exception {
        this.isValidString(s);
    }

    public int getBracketState(String c) {
        if (OPEN_BRACKETS.contains(c)) {
            return 1;
        }
        if (CLOSE_BRACKETS.contains(c)) {
            return 0;
        }
        return -1;
    }

    public boolean isValidString(String s) {
        Stack<String> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String character = s.substring(i, i + 1);
            switch (this.getBracketState(character)) {
                case 0:
                    if (brackets.peek().equals(OPEN_BRACKETS.get(CLOSE_BRACKETS.indexOf(character)))) {
                        brackets.pop();
                    } else {
                        return false;
                    }
                    break;
                case 1:
                    brackets.push(character);
                    break;
            }
        }
        return brackets.isEmpty();
    }
}
