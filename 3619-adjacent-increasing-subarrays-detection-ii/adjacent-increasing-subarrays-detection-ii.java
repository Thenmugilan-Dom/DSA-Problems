class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        int[] inc = new int[n];
        
        inc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums.get(i) < nums.get(i + 1)) {
                inc[i] = inc[i + 1] + 1;
            } else {
                inc[i] = 1;
            }
        }
        
        int left = 1, right = n / 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canFind(nums, inc, mid)) {
                ans = mid;
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        
        return ans;
    }
    
    private boolean canFind(List<Integer> nums, int[] inc, int k) {
        int n = nums.size();
        for (int i = 0; i + 2 * k <= n; i++) {
            if (inc[i] >= k && inc[i + k] >= k) {
                return true;
            }
        }
        return false;
    }
}
