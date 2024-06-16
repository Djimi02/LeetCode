public class ReverseStringWords {
    
    String reverseWords(String S)
    {
        String[] words = S.split("\\.");
        
        String output = "";
        for (int i = words.length - 1; i >= 0; i--) {
            output += words[i];
            if (i != 0) {
                output += "."; 
             }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringWords().reverseWords("i.like.this.program.very.much"));
    }
}