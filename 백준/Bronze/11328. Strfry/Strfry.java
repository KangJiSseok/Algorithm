import java.util.*;
import java.io.*;


class Main{

    static int[] before;
    static int[] after;


    public static void main(String[] args) throws Exception{

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            before = new int[26];
            after = new int[26];
            st = new StringTokenizer(br.readLine());
            String beforeText = st.nextToken();
            String afterText = st.nextToken();

            for(int k=0; k<beforeText.length(); k++){
                before[beforeText.charAt(k) - 'a']++;
            }

            for(int k=0; k<afterText.length(); k++){
                after[afterText.charAt(k) - 'a']++;
            }

            String resultText= "Possible";
            for(int k=0; k<26; k++){
                if(after[k] != before[k]) resultText = "Impossible";
            }
            sb.append(resultText+"\n");

        }

        System.out.println(sb);
        
    }
}