class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int mid;
        int a = n;
        while(low <= high){
            mid = (low + high)/2;
            if(target <= arr[mid]){
                a = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return a;
    }
}
