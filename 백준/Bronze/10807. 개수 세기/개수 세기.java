import java.util.*;
import java.io.*;


class Main{


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] number = new int[n+1];
        for(int i=1; i<=n; i++){
            number[i]=Integer.parseInt(st.nextToken());
        }

        int v =Integer.parseInt(br.readLine());


        int count = 0;
        for(int i=1; i<=n; i++){
            if(number[i] == v) count++;
        }

        System.out.println(count);

    }
}