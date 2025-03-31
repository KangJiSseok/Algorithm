class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] arr = new int[300];

        for (int i = lines[0][0] + 100; i < lines[0][1] + 100; i++) {
            arr[i]++;
        }

        for (int i = lines[1][0] + 100; i < lines[1][1] + 100; i++) {
            arr[i]++;
        }

        for (int i = lines[2][0] + 100; i < lines[2][1] + 100; i++) {
            arr[i]++;
        }

        for (int i = 0; i < 300; i++) {
            if (arr[i] >= 2) answer++;
        }

        return answer;
    }
}

