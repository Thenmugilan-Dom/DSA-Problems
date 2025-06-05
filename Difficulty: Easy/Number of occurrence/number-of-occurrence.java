class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        int n = arr.length;
        int low =0, high=n-1, mid;
        int[] a = {-1, -1};
        while(low<=high){
            mid = (low + high)/2;
            if(arr[mid] == target){
                a[0] = mid;
                high = mid -1;
            }
            else if(arr[mid] < target){
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
            if(arr[mid] == target){
                a[1] = mid;
                low = mid +1;
            }
            else if(arr[mid] < target){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        if(a[0] == -1){
            return 0;
        }
        return a[1] - a[0] + 1; 
    }
}
