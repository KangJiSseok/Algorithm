
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Math;

class Main{

    static int[] moneyList;
    static int N, M;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        moneyList = new int[N];

        int low = 0;
        int max = 0;
        for(int i=0; i<N; i++){
            moneyList[i] = Integer.parseInt(br.readLine());
            low = Math.max(low,moneyList[i]);
            max +=moneyList[i];
        }
        
        int result = binarySearch(low,max);

        System.out.println(result);

    }


    private static int binarySearch(int low, int high){

        int mid;
        int result = 0;

        while(low<=high){
            mid = (low+high) / 2;

            int midCount = search(mid);

            // max에 가까움
            if(midCount <= M){
                result = mid;
                high = mid -1;
            }
            else if( midCount > M){
                low = mid +1 ;
            }            
        }

        return result;
    }

    private static int search(int money){

        int count =1;
        int realMoney = money;

        for(int i=0; i<N; i++){

            if(money < moneyList[i]){
                money = realMoney;
                money = money - moneyList[i];
                count++;
            }
            else{
                money = money - moneyList[i];
            }
        }

        return count;

    }   


}