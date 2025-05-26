class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int element = num;
                int current = 1;

                while (numSet.contains(element + 1)) {
                    element++;
                    current++;
                }

                longest = Math.max(longest, current);
            }
        }

        return longest;
    }
}