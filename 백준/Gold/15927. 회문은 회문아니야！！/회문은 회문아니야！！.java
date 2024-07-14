import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String text = br.readLine();

        boolean palindrome = palindrome(text);

        if(palindrome){
            String newText = text.substring(0, text.length() - 1);
            boolean newPalindrome = palindrome(newText);
            if (newPalindrome) {
                sb.append(-1);
            }else{
                sb.append(newText.length());
            }
        }else {
            sb.append(text.length());
        }

        System.out.println(sb);

    }


    static boolean palindrome(String text) {
        for (int i = 0; i < text.length() / 2; i++) {
            if(text.charAt(i) != text.charAt(text.length() - 1 - i)) return false;

        }
        return true;
    }
}