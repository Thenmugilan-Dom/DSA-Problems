class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int l=1, h=n-2, m;
        
        if  (nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }
        while(l <= h){
            m =(l+h)/2;
            if(nums[m] != nums[m+1] && nums[m] != nums[m-1]){
                return nums[m];
            }
            if((nums[m] == nums[m-1] && m%2 == 1) || (nums[m] == nums[m+1] && m%2 == 0)){
                l = m+1;
            }
            else{
                h = m -1;
            }
        }
        return -1;
    }
}