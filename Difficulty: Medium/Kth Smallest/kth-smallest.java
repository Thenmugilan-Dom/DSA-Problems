// User function Template for Java

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        Arrays.sort(arr);
        int n = arr.length;
        for(int i =0; i<=n; i++){
            if(i == k){
                return arr[i-1];
            }
        }
        return -1;
    }
}
