import java.util.*;
import java.io.*;

class Main{

    static Deque<Integer> deque = new LinkedList<>();
    static int[] searchList;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        searchList = new int[M+1];

        for(int i=1; i<=N; i++){
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=M; i++){
            searchList[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int i=1; i<=M; i++){
            int search = searchList[i];

            int count =0;
            while(deque.contains(search)){
                if(deque.peekFirst() == search){
                    deque.pollFirst();
                }else{
                    deque.addLast(deque.pollFirst());
                    count++;
                }
            }

            result += Math.min(count, N-count);
            N--;
        }
        
        System.out.println(result);

    }
}