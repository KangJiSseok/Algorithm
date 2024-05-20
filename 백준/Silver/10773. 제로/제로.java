import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<n; i++){
            int value = Integer.parseInt(br.readLine());


            if(value != 0){
                deque.addFirst(value);
            }else{
                if(!deque.isEmpty()){
                    deque.pollFirst();
                }
            }
        }

        int sum =0;
        for(int poll : deque){
            sum+=poll;
        }

        System.out.println(sum);
    }
}