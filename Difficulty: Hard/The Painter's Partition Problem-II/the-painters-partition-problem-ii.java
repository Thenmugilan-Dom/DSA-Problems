// User function Template for Java

class Solution {
    
    public int minTime(int[] arr, int k) {
        
        int sum = 0;
        int max =Integer.MIN_VALUE;
        for(int a : arr){
            sum +=a;
            max = Math.max(max, a);
        }
        
        if(k == 1){
            return sum;
        }
        
        int low = max;
        int high = sum;
        int mid;
         
        while(low <= high){
            mid = low + (high - low)/2;
            
            int nos = countSum(arr, mid);
            if(nos > k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }
    
    public int countSum(int[] arr, int page){
        int student = 1;
        long count = 0;
        
        for(int i = 0; i< arr.length; i++){
            if(count + arr[i] <= page){
                count +=arr[i];
            }
            else{
                student++;
                count = arr[i];
            }
        }
        return student;
    }
}