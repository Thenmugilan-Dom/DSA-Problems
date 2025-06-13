
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int start = 0;
        int sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end]; 

            while (sum > target && start <= end) {
                sum -= arr[start++];
            }

            if (sum == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(start+1); 
                result.add(end+1);
                return result;
            }
        }

        return new ArrayList<>(Arrays.asList(-1));
    }
}
