import java.util.*;
import java.io.*;
import java.lang.*;


class Main{

    static int[] decrease;
    static int[] increase;
    static int N, answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        decrease = new int[N+1];
        increase = new int[N+1];

    
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            decrease[i] = Integer.parseInt(st.nextToken());
        }
    
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            increase[i] = Integer.parseInt(st.nextToken());
        }

        dfs(100,0,1);

        System.out.println(answer);
        

    }

    static int dfs(int hp, int happy, int index){
        if(index == N+1 && hp >0){
            answer = Math.max(answer,happy);
            return answer;
        }
        if(hp > 0){
            dfs(hp-decrease[index],happy+increase[index],index+1);
            dfs(hp,happy,index+1);
        }
        return answer;
    }
}