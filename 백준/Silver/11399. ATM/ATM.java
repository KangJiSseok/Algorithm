import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int sum = 0;
    static int sum1 = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<ATM> atm = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(st.nextToken());
            atm.add(new ATM(p, i));
        }

        Collections.sort(atm);

        for (ATM a : atm) {
            sum = a.p + sum;
            sum1 += sum;
        }

        System.out.println(sum1);

    }
}

class ATM implements Comparable<ATM> {
    int p;
    int sequence;

    public ATM(int p, int sequence) {
        this.p = p;
        this.sequence = sequence;
    }

    @Override
    public int compareTo(ATM o) {
        if (this.p > o.p) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "p=" + p +
                ", sequence=" + sequence +
                '}';
    }
}

