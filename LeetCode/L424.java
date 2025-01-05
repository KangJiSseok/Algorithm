class L424 {
    public int characterReplacement(String s, int k) {
        int[] alpha = new int[26];

        int l = 0, r = 0;
        int maxLength = 0;
        int maxCount = 0;
        while (r < s.length()) {
            alpha[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, alpha[s.charAt(r) - 'A']);
            while ((r - l + 1) - maxCount > k) {
                alpha[s.charAt(l) - 'A']--;
                l++;
            }

            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }

        return maxLength;
    }
}
