import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ascending = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = {8, 7, 6, 5, 4, 3, 2, 1};

        st = new StringTokenizer(br.readLine());

        int[] array = new int[8];
        int aCount = 0;
        int dCount =0;

        for (int i = 0; i < 8; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (ascending[i] == value) {
                aCount++;
            }
            if (descending[i] == value) {
                dCount++;
            }
        }

        if (aCount == 8) {
            System.out.println("ascending");
        } else if (dCount == 8) {
            System.out.println("descending");
        }else{
            System.out.println("mixed");
        }


    }
}



