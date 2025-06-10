class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 1; 
        int h = nums[n-1];
        while(l<=h){
            int mid = (l + h )/ 2;
            int sum = getsum(nums, mid);
            if(sum <=threshold){
            h=mid-1;
            }
            else{
               l=mid+1;
            }
        }
        return l;
    }

    public int getsum(int[] nums, int d){
        int sum = 0;
        for(int num : nums){
            sum += Math.ceil((double)(num)/d); 
        }
        return sum;
    }
}