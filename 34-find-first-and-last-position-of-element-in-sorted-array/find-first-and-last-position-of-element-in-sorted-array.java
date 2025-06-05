class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int low =0, high=n-1, mid;
        int[] a = {-1, -1};
        while(low<=high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                a[0] = mid;
                high = mid -1;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        low =0;
        high = n-1; 
        while(low<=high){
            mid = (low + high)/2;
            if(nums[mid] == target){
                a[1] = mid;
                low = mid +1;
            }
            else if(nums[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return a;
    }
}