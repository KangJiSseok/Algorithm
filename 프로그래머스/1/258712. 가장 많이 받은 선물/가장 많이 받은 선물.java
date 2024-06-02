import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public int solution(String[] friends, String[] gifts) {

        HashMap<String, Integer> map = new HashMap<>();
        int len = friends.length;

        int[] getList = new int[len];
        int[][] graph = new int[len][len];

        for (int i = 0; i < len; i++) {
            map.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; i++) {
            StringTokenizer st = new StringTokenizer(gifts[i]);
            int push = map.get(st.nextToken());
            int get = map.get(st.nextToken());
            getList[push]++;
            getList[get]--;
            graph[push][get]++;
        }

        int result = 0;
        for (int i = 0; i < len; i++) {
            int max = 0;
            for (int k = 0; k < len; k++) {
                if ((graph[i][k] == graph[k][i]) && (getList[i] > getList[k])) {
                    max++;
                }
                if (graph[i][k] > graph[k][i]) max++;
            }

            result = Math.max(result, max);
        }


        int answer = result;
        return answer;
    }
}
