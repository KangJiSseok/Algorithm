class L5 {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;

        for(int i = 0; i < s.length(); i++) {
            int len1 = palindrome(s, i, i);
            int len2 = palindrome(s, i, i + 1);
            int len = Math.max(len1, len2);
            if(len > right - left) {
                left = i - ((len - 1) / 2);
                right = i + (len / 2);
            }
        }

        return s.substring(left, right + 1);
    }
    private int palindrome(String s, int left, int right) {

        while(0 <= left && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
