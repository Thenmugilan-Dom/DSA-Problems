class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int n = nums.length;

        for (int[] arr : nums) {
            Set<Integer> seen = new HashSet<>();
            for (int num : arr) {
                if (seen.add(num)) { 
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == n) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }
}