import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        int[] stackList = new int[n+1];
        for(int i=1; i<=n; i++){
            stackList[i] = Integer.parseInt(br.readLine());
        }

        int index =0;
        for(int i=1; i <=stackList[1]; i++){
            deque.addFirst(i);
            index = i;
            sb.append("+").append("\n");
        }

        for(int i=1; i<=n ; i++){
            if(stackList[i] > index){
                //deque에 6까지 넣어야함.
                for(int k= index+1; k<=stackList[i]; k++){
                    deque.addFirst(k);
                    sb.append("+").append("\n");
                }
                index = stackList[i];             
            }
            if(stackList[i] <= index) {
                if(deque.pollFirst() == stackList[i]){
                    sb.append("-").append("\n");
                }else{
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}