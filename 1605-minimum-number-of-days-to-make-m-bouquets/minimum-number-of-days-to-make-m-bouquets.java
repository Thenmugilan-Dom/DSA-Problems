import java.util.Arrays;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (m * k > n) return -1;

        int l = 1;
        int h = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (isposs(m, k, bloomDay, mid)) {
                ans = mid;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    public boolean isposs(int m, int k, int[] bloomDay, int d) {
        int bc = 0; 
        int count = 0; 

        for (int bloom : bloomDay) {
            if (bloom <= d) {
                count++;
                if (count == k) {
                    bc++;
                    count = 0;
                    if (bc >= m) return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
