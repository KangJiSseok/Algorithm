import java.util.Arrays;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {

        String[] myString = new String[my_string.length()];

        for (int i = 0; i < my_string.length(); i++) {
            myString[i] = String.valueOf(my_string.charAt(i));
        }

        String[] overwriteString = new String[overwrite_string.length()];

        for (int i = 0; i < overwrite_string.length(); i++) {
            overwriteString[i] = String.valueOf(overwrite_string.charAt(i));
        }

        for (int i = 0; i < overwrite_string.length(); i++) {
            myString[i+s] = overwriteString[i];
        }

        String answer = "";
        for (int i = 0; i <my_string.length() ; i++) {
            answer += myString[i];
        }

        System.out.println("answer = " + answer);
        return answer;
    }

}