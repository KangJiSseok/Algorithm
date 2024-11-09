class 퍼즐게임챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        return binary_search(diffs, times, limit);
    }

    private int binary_search(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100000;

        while (min <= max) {
            int mid = (min + max) / 2;
            long time = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= mid) time += times[i];
                else time += (long) (times[i] + times[i - 1]) * (diffs[i] - mid) + times[i];

            }
            if (time > limit) min = mid + 1;
            else max = mid - 1;
        }

        return min;
    }
}