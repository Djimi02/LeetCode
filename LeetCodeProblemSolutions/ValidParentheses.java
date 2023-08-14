import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {

    public boolean isValid(String s) {
        List<Character> openingPar = new ArrayList<>();
        Boolean output = true;

        if (s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                openingPar.add(currentChar);
                continue;
            }

            if (openingPar.size() == 0 && (currentChar == ')' || currentChar == '}' || currentChar == ']')) {
                return false;
            }

            if (currentChar == '}' && openingPar.get(openingPar.size() - 1) == '{' ||
            currentChar == ')' && openingPar.get(openingPar.size() - 1) == '(' || 
            currentChar == ']' && openingPar.get(openingPar.size() - 1) == '[') {
                openingPar.remove(openingPar.size() - 1);
            } else {    
                return false;
            }

        }

        if (openingPar.size() != 0) {
            return false;
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("(]"));
    }
}
