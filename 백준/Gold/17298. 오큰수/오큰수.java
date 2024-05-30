import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<n; i++){
            while(!deque.isEmpty() && arr[deque.peek()] < arr[i]) {
                arr[deque.pop()] = arr[i];
            }
            deque.addFirst(i);
        }

        while (!deque.isEmpty()){
            arr[deque.pollFirst()] = -1;
        }

        for(int i=0; i<n; i++){
            sb.append(arr[i] + " ");
        }

        System.out.println(sb);

    }
}