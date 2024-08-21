import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static int mi;
    static int pi;
    static int result =0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> minusList = new ArrayList<>();
        ArrayList<Integer> plusList = new ArrayList<>();

        int minusCount = 0;
        int plusCount = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= 0)
            {
                minusList.add(num);
                minusCount++;
            }
            else {
                plusList.add(num);
                plusCount++;
            }
        }

        Collections.sort(minusList);
        Collections.sort(plusList, Comparator.reverseOrder());

        mi = 0;
        //짝수개일때
        if (minusCount % 2 == 0) {
            while(mi < minusCount){
                result += minusList.get(mi) * minusList.get(mi + 1);
                mi += 2;
            }
        }
        //홀수개일때
        else if (minusCount % 2 == 1) {
            while (mi < minusCount - 1) {
                result += minusList.get(mi) * minusList.get(mi + 1);
                mi += 2;
            }
            result += minusList.get(mi);
        }

        pi = 0;
        if (plusCount % 2 == 0) {
            while(pi < plusCount){
                if (plusList.get(pi) * plusList.get(pi + 1) == plusList.get(pi)) {
                    result += plusList.get(pi) + plusList.get(pi + 1);
                }else{
                    result += plusList.get(pi) * plusList.get(pi + 1);
                }
                pi += 2;
            }
        }
        //홀수개일때
        else if (plusCount % 2 == 1) {
            while (pi < plusCount - 1) {
                if (plusList.get(pi) * plusList.get(pi + 1) == plusList.get(pi)) {
                    result += plusList.get(pi) + plusList.get(pi + 1);
                }else{
                    result += plusList.get(pi) * plusList.get(pi + 1);
                }
                pi += 2;
            }
            result += plusList.get(pi);
        }

        System.out.println(result);
    }
}