import java.util.*;
import java.io.*;

public class Main {

    static int[] card;
    static int[] searchCard;


    public static void main(String[] args) throws IOException {
        //===========초기화===========//
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        card = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        searchCard = new int[M];
        for (int i = 0; i < M; i++) {
            searchCard[i] = Integer.parseInt(st.nextToken());
        }


        //정렬
        Arrays.sort(card);
        //-10 2 3 6 10


        for (int i = 0; i < M; i++) {
            if(binarySearch(searchCard[i])){
                sb.append(1 + " ");
            }else{
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);
    }

    static boolean binarySearch(int searchValue) {
        int left = 0;
        int right = card.length - 1;

        while (left <= right) {
            int mid = (left + right)/2;
            if(card[mid] == searchValue) return true;
            else if(card[mid] < searchValue){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }


        return false;
    }
}
