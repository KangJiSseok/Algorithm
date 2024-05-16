import java.util.*;
import java.io.*;
import java.lang.*;

class Main{
    public static void main(String[] args)throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String dataA = br.readLine();

        int[] a = new int[26];
        int[] b = new int[26];

        for(int i=0; i<dataA.length(); i++){
            a[dataA.charAt(i)-97]++;
        }

        String dataB = br.readLine();

        for(int i=0; i<dataB.length(); i++){
            b[dataB.charAt(i)-97]++;
        }

        int result = 0;

        for(int i=0; i<26; i++){
            if(a[i] == b[i]) continue;
            int abs = Math.abs(a[i]-b[i]);
            result += abs;
        }
        System.out.println(result);

    }
}