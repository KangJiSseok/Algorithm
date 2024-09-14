import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] parent;
    static int M;
    static int N;
    static HashMap<Integer, Integer> factMap = new HashMap();
    static List<List<Integer>> list = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int factSize = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= factSize; i++) {
            int value = Integer.parseInt(st.nextToken());
            factMap.put(value,value);
        }

        for (int i = 0; i < M; i++) {
            List<Integer> people = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int iter = Integer.parseInt(st.nextToken());
            for (int j = 0; j < iter; j++) {
                people.add(Integer.parseInt(st.nextToken()));
            }
            list.add(i, people);
        }

        //union find 시작
        for (int i = 0; i < M; i++) {
            List<Integer> participants = list.get(i);
            for (int j = 0; j < participants.size() - 1; j++) {
                union(participants.get(j), participants.get(j + 1));
            }
        }

//        for (int i : parent) {
//            System.out.println(i + " ");
//        }
//
//        for (Map.Entry<Integer, Integer> integerIntegerEntry : factMap.entrySet()) {
//            System.out.println("key : " + integerIntegerEntry.getKey() + ", value : "+integerIntegerEntry.getValue() );
//        }

        for (List<Integer> participants : list) {
            boolean cascade = true;
            for (Integer participant : participants) {
                if (factMap.containsKey(find(participant))) {
                    cascade = false;
                    break;
                }
            }
            if (cascade) {
                result++;
            }
        }
        System.out.println(result);
    }
    
    private static void union(int a, int b) {
        int findA = find(a);
        int findB = find(b);

        if (findA == findB) return;

        if (factMap.containsKey(findA) || factMap.containsKey(findB)) {
            factMap.put(findA, findA);
            factMap.put(findB, findA);
        }

        if (findA < findB) {
            parent[findB] = findA;
        } else {
            parent[findA] = findB;
        }
    }


    private static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }
}
