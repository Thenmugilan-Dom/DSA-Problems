class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int l = 0, h = n-1, mid;
        int ans = nums[0];
        while(l <= h){
            if(nums[l] < nums[h]){
                ans = Math.min(ans, nums[l]);
            }
            mid = (l + h)/2;
            ans = Math.min(ans, nums[mid]);

            if(nums[l] <= nums[mid]){
                l = mid+1;
            }
            else{
               h = mid-1;
            }
        }
        return ans;
    }
}