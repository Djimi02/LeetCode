import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    private boolean areSectionsValid(String[] sections) {
        for (int i = 0; i < sections.length; i++) {
            String sec = sections[i];
            if (sec.length() < 1 || sec.length() > 3) {
                return false;
            }
            if (sec.length() > 1 && sec.charAt(0) == '0') {
                return false;
            }

            try {
                int num = Integer.parseInt(sec);

                if (num > 255) {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return true;
    }

    private void recursion(String s, List<String> list, int pointer) {
        String[] sections = s.split("\\.");
        if (sections.length == 4) {
            if (areSectionsValid(sections)) {
                list.add(s);
            }
            return;
        }

        if (pointer >= s.length()) {
            return;
        }

        for (int i = pointer+1; i < s.length(); i++) {
            String s1 = s.substring(0, i) + "." + s.substring(i);

            recursion(s1, list, i+1);
        }

    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<>();
        }
        
        ArrayList<String> output = new ArrayList<>();
        recursion(s, output, 0);

        return output;
    }

    public static void main(String[] args) {
        // String s = "1234";
        // s = s.substring(0, 1 + 1) + "." + s.substring(1 + 1 );
        // System.out.println(s);
        // System.out.println(s.contains("."));
        // System.out.println(s.split("\\.").length);

        List<String> output = new RestoreIPAddresses().restoreIpAddresses("101023");

        for (var ip : output) {
            System.out.println(ip);
        }
    }
}