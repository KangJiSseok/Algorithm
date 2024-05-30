import java.util.*;
import java.io.*;


class Main{
    public static void main(String[] args) throws Exception{

        Deque<Integer> deque = new LinkedList<>();
        long answer=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i< N; i++){
            int data  = arr[i];
            while(!deque.isEmpty()){
                if(deque.peekFirst() <= data){
                    deque.pollFirst();
                }else{
                    break;
                }   
            }
            answer += deque.size();
            deque.addFirst(data);
        }

        System.out.println(answer);
        
    }
}