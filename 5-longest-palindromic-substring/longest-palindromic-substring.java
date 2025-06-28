class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 1) return "";

        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            int l1 = center(s, i, i);       
            int l2 = center(s, i, i + 1);   
            int l = Math.max(l1, l2);

            if (l > end - start) {
                start = i - (l - 1) / 2;
                end = i + l / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int center(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
