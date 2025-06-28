class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] paired = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            paired[i][0] = nums[i];
            paired[i][1] = i;
        }
        Arrays.sort(paired, (a, b) -> Integer.compare(b[0], a[0]));
        int[][] topK = Arrays.copyOfRange(paired, 0, k);
        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}