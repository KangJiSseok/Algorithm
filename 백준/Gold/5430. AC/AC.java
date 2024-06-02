import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        // 바꿀 필요가 없음
        // R -> Deque의 출력 방향 바꾸기
        // D -> Deque의 현재 출력방향에서 한개 빼기
        // result -> 현재 출력 방향의 앞쪽에서 뺴기

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            AC();
            sb.append("\n");  // 각 테스트 케이스 끝날 때마다 줄바꿈 추가
        }

        System.out.print(sb);  // 루프 끝난 후 한 번에 출력
    }

    public static void AC() throws Exception {
        sb.append("[");

        Deque<Integer> deque = new LinkedList<>();
        boolean direction = true;
        String p = br.readLine();
        int n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), "[],");
        for (int i = 0; i < n; i++) {
            deque.addFirst(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < p.length(); i++) {
            char dir = p.charAt(i);
            if (dir == 'R') {
                direction = !direction;
                continue;
            }

            if (deque.isEmpty()) {
                sb.setLength(sb.length() - 1);  // 마지막 "["를 제거
                sb.append("error");
                return;
            }

            if (direction) {
                deque.pollLast();
            } else {
                deque.pollFirst();
            }
        }

        if (direction) {
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast()).append(",");
            }
        } else {
            while (!deque.isEmpty()) {
                sb.append(deque.pollFirst()).append(",");
            }
        }
        if(sb.length() > 1 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
    }
}
