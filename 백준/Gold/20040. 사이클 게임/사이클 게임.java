import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int iter = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= iter; i++) {
            st = new StringTokenizer(br.readLine());
            if(union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))){
                System.out.println(i);
                return;
            }
        }

        System.out.println(0);
        
    }

    static boolean union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if(parentA == parentB) return true;

        else if (parentA > parentB) {
            parent[parentA] = parentB;
        }else{
            parent[parentB] = parentA;
        }
        return false;
    }

    static int find(int value) {
        if (parent[value] == value) return value;
        return parent[value] = find(parent[value]);
    }
}

