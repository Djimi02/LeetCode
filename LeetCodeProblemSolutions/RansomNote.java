public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomNoteArr = ransomNote.toCharArray();
        char[] magazineArr = magazine.toCharArray();
        boolean output = true;

        for (int i = 0; i < magazineArr.length; i++) {
            for (int j = 0; j < ransomNoteArr.length; j++) {
                if (magazineArr[i] == ransomNoteArr[j]) {
                    ransomNoteArr[j] = ' ';
                    break;
                }
            }
        }

        for (int i = 0; i < ransomNoteArr.length; i++) {
            if (ransomNoteArr[i] != ' '){
                output = false;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(new RansomNote().canConstruct("aa", "aab"));
    }
}
