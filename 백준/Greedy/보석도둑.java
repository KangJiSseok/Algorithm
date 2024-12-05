import java.util.*;
import java.io.*;

public class 보석도둑 {
    static int N, K;
    static Jewel[] jewels;
    static int[] bags;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, (a,b) -> {
            return Integer.compare(a.weight, b.weight);
        });
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b, a);
        });


        long sum = 0;
        int index = 0;
        for (int i = 0; i < K; i++) {
            while (index < N && jewels[index].weight <= bags[i]) {
                pq.add(jewels[index].value);
                index++;
            }

            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }

    static class Jewel{
        int weight;
        int value;
        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
