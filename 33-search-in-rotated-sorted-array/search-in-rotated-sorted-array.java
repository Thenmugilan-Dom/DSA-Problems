class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l =0;
        int h = n-1;
        int m;
        while(l <= h){
            m = (l+h)/2;
            if(target == nums[m]){
                return m;
            }
            else if(nums[l] <= nums[m]){
                if(target >= nums[l] && target < nums[m]){
                    h = m-1;
                }
                else{
                    l = m+1;
                }
            }
            else{
                if(target > nums[m] && target <= nums[h]){
                    l = m+1;
                }
                else{
                    h = m-1;
                }
            }
        }
        return -1;
    }
}