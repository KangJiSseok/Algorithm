import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack = new Stack<>();
    static String text;
    static String comText;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        comText = br.readLine();

        char comEnd = comText.charAt(comText.length() - 1);

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
            if (stack.peek() == comEnd) {
                while(true){
                    if (!compare()) {
                        break;
                    }
                }
            }
        }

        if(stack.isEmpty()) sb.append("FRULA");
        else{
            for (Character character : stack) {
                sb.append(character);
            }
        }

        System.out.println(sb.toString());  
    }

    static boolean compare() {
        char[] comArray = new char[comText.length()];
        if(stack.size() < comText.length()) return false;
        int k =0;
        for (int i = comText.length() - 1 ; i >= 0; i--) {
            if (stack.peek() == comText.charAt(i)) {
                stack.pop();
                comArray[i] = comText.charAt(i);
            }
            else{
                break;
            }
            k++;
        }

        if(k == comText.length()) return true;

        for (int i = comText.length() - k; i < comText.length(); i++) {
            stack.push(comText.charAt(i));
        }
        return false;
    }


}
