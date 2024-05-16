import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String data = br.readLine();

        int[] a = new int[26];

        for(int i=0; i<data.length(); i++){
            a[data.charAt(i)-97]++;
        }

        for(int i=0; i<26; i++){
            sb.append(a[i]).append(" ");
        }

        System.out.println(sb);

    }
}