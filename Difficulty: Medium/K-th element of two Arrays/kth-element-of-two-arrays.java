// User function Template for Java

class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        int n = a.length;
        int m = b.length;
        int size =0;
        int[] arr = new int[n+m];
        for(int i=0; i<n; i++){
          arr[size] = a[i];
          size++;
        }
        for(int i=0; i<m; i++){
            arr[size] = b[i];
            size++;
        }
        
        Arrays.sort(arr);
        return arr[k-1];
        
        
    }
}