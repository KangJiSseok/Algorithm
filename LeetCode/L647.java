class L647 {
    public int countSubstrings(String s) {
        int result = 0;

        for(int i = 0; i < s.length(); i++){
            result += palindrome(s, i, i);
            result += palindrome(s, i, i + 1);
        }

        return result;
    }

    private int palindrome(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
