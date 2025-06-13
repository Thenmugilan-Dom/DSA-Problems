class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int left = 1;
        int right = 0;
        for (int pile : arr) {
            right = Math.max(right, pile);
        }

        int ans = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int time = 0;

            for (int pile : arr) {
                time += (pile + mid - 1) / mid; 
            }

            if (time > k) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }

        return ans;
    }
}
