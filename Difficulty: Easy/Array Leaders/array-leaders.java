class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
         ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        
        int maxFromRight = arr[n - 1];
        result.add(maxFromRight); 
        
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                result.add(maxFromRight);
            }
        }
        
        Collections.reverse(result);
        return result;
        
    }
}
