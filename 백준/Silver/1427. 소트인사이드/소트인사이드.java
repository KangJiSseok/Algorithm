import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        int length = T.length();

        String[] token = T.split("");
        int[] init = new int[length];
        int[] increase = new int[length];


        for (int i = 0; i < length; i++) {
            init[i] = Integer.parseInt(token[i]);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < length; i++) {
            heap.add(init[i]);
        }

        for (int i = 0; i < length; i++) {
            increase[i] = heap.poll();
        }

        for (int i = 0; i < T.length(); i++) {
            System.out.printf("%d",increase[i]);
        }

    }

}