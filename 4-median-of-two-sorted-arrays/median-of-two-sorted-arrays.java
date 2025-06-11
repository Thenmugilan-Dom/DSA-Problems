class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    
    

  
        int size =0;
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m+n];
        for(int i=0;i<m;i++){
            arr[size] = nums1[i];
            size++;
        }
        for(int i=0; i<n; i++){
            arr[size] = nums2[i];
            size++;
        }

         Arrays.sort(arr);
         int x= arr.length;
         if(x%2==0)
         {
            return (arr[x/2-1]+arr[x/2])/2.0;
         }else{
            return arr[x/2];
         }
        
    }
}