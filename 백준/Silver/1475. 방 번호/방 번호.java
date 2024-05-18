import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstText = br.readLine();
        int[] numberList = new int[10];
        for(int i=0; i< firstText.length(); i++){
            numberList[firstText.charAt(i)-'0']++;
        }

        numberList[9] += numberList[6];
        numberList[6] = 0;

        int max = 0;
        for(int i=0; i<10; i++){
            if(i == 9) {
                max = Math.max(max, (numberList[i]+1)/2);
                continue;
            }
            max = Math.max(max, numberList[i]);
        }

        System.out.println(max);
    }
}