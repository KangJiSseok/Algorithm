import java.util.*;
import java.io.*;


class Main{


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nList= new int[n+1];

        for(int i=1; i<=n; i++){
            nList[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());
        Arrays.sort(nList);

        int tail = 1;
        int head = n;
        int count =0;

        while(tail < head){
            if(nList[tail]+nList[head] == x) count++;
            if(nList[tail]+nList[head] <= x) tail++;
            else head --;
        }

        System.out.println(count);
    }
}