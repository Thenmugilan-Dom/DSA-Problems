class Solution {
    public int splitArray(int[] nums, int k) {
        int left = 0; 
        int right = 0; 
        
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }
        
        return left;
    }
    
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum + num <= maxSum) {
                currentSum += num;
            } else {
                count++;
                currentSum = num;
                if (count > k) {
                    return false; 
                }
            }
        }
        return true;
    }
}