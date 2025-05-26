class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        a.put(0, 1); 

        for (int num : nums) {
            sum += num;
            if (a.containsKey(sum - k)) {
                count += a.get(sum - k);
            }
            a.put(sum, a.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}