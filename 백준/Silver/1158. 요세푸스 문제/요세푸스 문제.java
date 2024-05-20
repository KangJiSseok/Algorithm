import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        

        Deque<Integer> deque = new LinkedList<Integer>();

        for(int i=1; i<= n; i++){
            deque.addLast(i);
        }


        sb.append("<");
        while(!deque.isEmpty()){

            for(int j =1; j<=k; j++){
                if( j == k) {
                    sb.append(", "+deque.pollFirst());
                    
                }
                else{
                deque.addLast(deque.pollFirst());
                }
            }
        }

        sb.append(">");

        String text = sb.toString();
        sb.setLength(0);
        

        for(int i=0; i<text.length(); i++){
            if( i== 1 || i== 2) continue;
            sb.append(text.charAt(i));
        }

        System.out.println(sb);
        
    }
}


