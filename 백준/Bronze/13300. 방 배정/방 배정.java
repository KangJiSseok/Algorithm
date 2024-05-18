import java.util.*;
import java.io.*;


class Main{

    static int[] womanGrade = new int[7];
    static int[] manGrade = new int[7];


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<= N; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if(gender == 0) womanGrade[grade]++;
            if(gender == 1) manGrade[grade]++;
        }

        int count =0;
        for(int i=1 ; i<=6; i++){
            count += (womanGrade[i]+(K-1))/K;
            count += (manGrade[i]+(K-1))/K;
        }

        System.out.println(count);

    }
}