class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums1) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums2) {
            if (countMap.containsKey(num) && countMap.get(num) > 0) {
                resultList.add(num);
                countMap.put(num, countMap.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}