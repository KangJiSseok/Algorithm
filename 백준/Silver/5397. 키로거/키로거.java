import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int k = 0; k < n; k++) {
            String text = br.readLine();

            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();


            for (int i = 0; i < text.length(); i++) {

                char value = text.charAt(i);

                switch (value) {
                    case '<':
                        if (!left.isEmpty()) {
                            right.addFirst(left.pollLast());
                        }
                        break;
                    case '>':
                        if (!right.isEmpty()) {
                            left.addLast(right.pollFirst());
                        }
                        break;
                    case '-':
                        if (!left.isEmpty()) {
                            left.removeLast();
                        }
                        break;

                    default:
                        left.addLast(value);
                        break;
                }
            }

            for (char ch : left) {
                sb.append(ch);
            }

            for (char ch : right) {
                sb.append(ch);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}