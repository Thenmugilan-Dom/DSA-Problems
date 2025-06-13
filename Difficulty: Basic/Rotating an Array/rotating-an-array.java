// User function Template for Java

class Solution {
    void leftRotate(int arr[], int d) {
        // code here
        int n = arr.length;
        d = d % n; 
        rev(arr, 0, n - 1);
        rev(arr, 0, n - d - 1);
        rev(arr, n - d, n - 1);
    }

    public void rev(int[] arr, int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        
    }
}
