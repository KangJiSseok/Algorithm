import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String n = br.readLine();
        int m = Integer.parseInt(br.readLine().strip());
        
        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();
        
        for (char ch : n.toCharArray()) {
            left.addLast(ch);
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            
            switch (command) {
                case "L":
                    if (!left.isEmpty()) {
                        right.addFirst(left.pollLast());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.addLast(right.pollFirst());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                    break;
                case "P":
                    String toInsert = st.nextToken();
                    left.addLast(toInsert.charAt(0));
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (char ch : left) {
            sb.append(ch);
        }
        for (char ch : right) {
            sb.append(ch);
        }
        
        System.out.println(sb.toString());
    }
}
