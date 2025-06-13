class Solution {
    int maxSubarraySum(int[] arr) {
        // Your code here
        int n = arr.length;
        int max =arr[0];
        int sum =arr[0];
        for(int i =1; i<n; i++){
            sum = Math.max(arr[i], sum+arr[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}
