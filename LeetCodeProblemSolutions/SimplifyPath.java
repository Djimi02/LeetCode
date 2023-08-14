import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

    public String simplifyPath2(String path) {

        String output = "/";
        if (path.length() == 1) {
            return output;
        }

        List<String> directories = new ArrayList<>();
        char lastCharacter = path.charAt(0);
        char nextCharacter;
        String lastDirectory = "";
        boolean directoryDetected = false;

        for (int i = 1; i < path.length(); i++) {

            if (!(path.charAt(i) == '.' || path.charAt(i) == '/')) {
                directoryDetected = true;
            }

            if (i + 1 < path.length()) {
                nextCharacter = path.charAt(i + 1);
            } else {
                nextCharacter = ' ';
            }

            if (path.charAt(i) == '/') {
                if (!lastDirectory.isEmpty()) {
                    lastDirectory += '/';
                    directories.add(lastDirectory);
                    lastDirectory = "";
                }
                lastCharacter = '/';
                directoryDetected = false;
                continue;
            }

            if (directoryDetected) {
                lastDirectory += path.charAt(i);
                lastCharacter = path.charAt(i);
                continue;
            }

            // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

            if (!(lastCharacter == '.') && path.charAt(i) == '.' && (nextCharacter == '/' || nextCharacter == ' ')) {
                lastDirectory = "";
                lastCharacter = path.charAt(i);
                continue;
            }

            if (lastCharacter == '.' && path.charAt(i) == '.' && (nextCharacter == '/' || nextCharacter == ' ')) {
                lastDirectory = "";
                lastCharacter = path.charAt(i);
                if (!directories.isEmpty()) {
                    directories.remove(directories.size() - 1);
                }
                continue;
            } else if (lastCharacter == '.' && path.charAt(i) == '.' && nextCharacter == '.') {
                directoryDetected = true;
                lastCharacter = path.charAt(i);
                lastDirectory += path.charAt(i);
                continue;
            }

            lastDirectory += path.charAt(i);
            lastCharacter = path.charAt(i);
        }

        if (!lastDirectory.isEmpty()) {
            lastDirectory += '/';
            directories.add(lastDirectory);
        }

        for (String string : directories) {
            output += string;
        }

        if (directories.size() > 0) {
            output = output.substring(0, output.length() - 1);
        }

        return output;
    }

    // public String simplifyPath(String path) {

    // String output = "/";
    // if (path.length() == 1) {
    // return output;
    // }

    // List<String> directories = new ArrayList<>();
    // char lastCharacter = path.charAt(0);
    // char nextCharacter;
    // String lastDirectory = "";

    // for (int i = 1; i < path.length(); i++) {
    // if (i + 1 < path.length()) {
    // nextCharacter = path.charAt(i + 1);
    // } else {
    // nextCharacter = ' ';
    // }

    // if (path.charAt(i) == '/' && lastCharacter == '/') {
    // continue;
    // }

    // if (!(path.charAt(i) == '/') && lastCharacter == '/' &&
    // !(lastDirectory.isEmpty())) {
    // directories.add(lastDirectory);
    // lastDirectory = "";
    // }

    // if (path.charAt(i) == '.' && !(lastCharacter == '.') && !(nextCharacter ==
    // '.')) {
    // lastDirectory = "";
    // }
    // if (path.charAt(i) == '.' && lastCharacter == '.' && !(nextCharacter == '.'))
    // {
    // lastDirectory = "";

    // continue;
    // }

    // lastDirectory += path.charAt(i);
    // lastCharacter = path.charAt(i);
    // }

    // directories.add(lastDirectory);

    // for (String string : directories) {
    // output += string;
    // }

    // if (directories.size() > 0) {
    // output = output.substring(0, output.length() - 1);
    // }

    // return output;
    // }

    public static void main(String[] args) {
        String path = "/home//foo/";
        String path2 = "/../";
        String path3 = "/home/";
        String path4 = "/a/./b/../../c/";
        String path5 = "/...";
        String path6 = "/..hidden";
        String path7 = "/a//b////c/d//././/..";
        System.out.println(new SimplifyPath().simplifyPath2("/."));
    }
}
