import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        List<Integer> stationList = new LinkedList<>();
        for (int station : stations) {
            stationList.add(station);
        }

        if (stationList.get(0) - w >= 2) {
            stationList.add(0, w + 1);
            answer++;
        }


        if (stationList.get(stationList.size() - 1) + w <= n - 1) {
            stationList.add(n - w);
            answer++;
        }

        for (int i = 0; i < stationList.size() - 1; i++) {
            int distance = stationList.get(i + 1) - stationList.get(i) - 1 - 2 * w;
            if (distance > 0) {
                answer += (distance + 2 * w) / (2 * w + 1);
            }
        }

        return answer;
    }
}