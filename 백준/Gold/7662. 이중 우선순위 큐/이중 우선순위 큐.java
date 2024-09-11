import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= testCase; i++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int T = Integer.parseInt(br.readLine());
            for (int j = 1; j <= T; j++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int inputValue = Integer.parseInt(st.nextToken());

                switch (command) {
                    case 'I':
                        map.put(inputValue, map.getOrDefault(inputValue,0) + 1);
                        break;
                    case 'D':
                        if(map.isEmpty()) continue;
                        int pop;
                        if (inputValue == -1) { //최소값 삭제
                            pop = map.firstKey();
                        } else {   //최대값 삭제
                            pop = map.lastKey();
                        }
                        if (map.get(pop) - 1 == 0) {
                            map.remove(pop);
                        }else{
                            map.put(pop, map.get(pop) - 1);
                        }
                        break;
                }
            }
            if(map.isEmpty()) sb.append("EMPTY\n");
            else{
                sb.append(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }
        System.out.println(sb.toString());

    }
}

