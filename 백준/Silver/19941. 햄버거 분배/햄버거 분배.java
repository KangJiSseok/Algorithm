import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
    static int count = 0;
    static int[] tableArray;
    static boolean visit;
    public static void main(String[] args)throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //햄버거면 1 , 사람이면 2
        tableArray = new int[N];
        
        String table = br.readLine();

        for(int i =0; i<N; i++){
            if(table.charAt(i) =='H') tableArray[i] = 1;
            else tableArray[i] = 2;
        }

        for(int i= 0 ; i < N; i++){
            visit = false;
            if(tableArray[i] != 2) continue;

            //왼쪽 찾기
            for(int j=0; j < K; j++){
                if((i-K+j) >=0){
                    if(tableArray[i-K+j] == 1){
                        tableArray[i-K+j] = 0;  //햄버거 먹음
                        count++;
                        visit = true;
                        break;
                    }
                }
            }

            //오른쪽 찾기
            if(visit == true) continue;
            for (int j = 0; j < K; j++) {
                if((i+1+j) <N){
                    if(tableArray[i+1+j] == 1){
                        tableArray[i+1+j] = 0;
                        count++;
                        break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}