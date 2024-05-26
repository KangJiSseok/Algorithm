import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<int[]> deque = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            int top = Integer.parseInt(st.nextToken());
//            System.out.println("top = " + top);
            while(!deque.isEmpty()) {
//                System.out.println("deque.peekFirst()[1] = " + deque.peekFirst()[1]);
                if(deque.peekFirst()[1] >= top) {
                    sb.append(deque.peekFirst()[0] + " ");
                    break;
                }
                deque.pollFirst();
            }
            if(deque.isEmpty()) {
                sb.append("0 ");
            }
            deque.addFirst(new int[] {i, top});
        }

        System.out.println(sb);
    }
}