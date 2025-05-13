class Solution {
    public boolean isPalindrome(String s) {
         s = s.toLowerCase();
        StringBuilder a = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                a.append(c);
            }
        }
        String Str = a.toString();
        String rev = a.reverse().toString();
        return Str.equals(rev);
    }
}