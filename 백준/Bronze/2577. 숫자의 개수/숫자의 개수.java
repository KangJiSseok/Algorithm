import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long a = Long.parseLong(br.readLine());
        long b = Long.parseLong(br.readLine());
        long c = Long.parseLong(br.readLine());

        
        long mul = a*b*c;

        String stringMul = "";
        stringMul += mul;
     
        int[] numberList = new int[10];
        for(int i=0; i< stringMul.length(); i++){
            numberList[(int) (stringMul.charAt(i) - '0')]++;
        }
        for(int i=0; i< 10; i++){
            sb.append(numberList[i]+"\n");
        }
        System.out.println(sb);
    }
}