import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소힙 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            switch (value) {
                case 0 :
                    if (pq.isEmpty()) {sb.append("0\n");}
                    else{sb.append(pq.poll() + "\n");}
                    break;
                default:
                    pq.add(value);
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}



