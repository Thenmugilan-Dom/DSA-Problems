class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            for (long i = (long)Math.pow(10, (len - 1) / 2); count < n && i < (long)Math.pow(10, (len + 1) / 2); i++) {
                long pal = createPalindrome(i, len % 2 == 1);
                if (isPalindromeInBaseK(pal, k)) {
                    sum += pal;
                    count++;
                }
            }
            len++;
        }
        return sum;
    }

    private long createPalindrome(long half, boolean oddLength) {
        long pal = half;
        if (oddLength) half /= 10;
        while (half > 0) {
            pal = pal * 10 + (half % 10);
            half /= 10;
        }
        return pal;
    }

    private boolean isPalindromeInBaseK(long num, int base) {
        List<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add((int)(num % base));
            num /= base;
        }
        int i = 0, j = digits.size() - 1;
        while (i < j) {
            if (!digits.get(i).equals(digits.get(j))) return false;
            i++;
            j--;
        }
        return true;
    }
}