class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long totalSum = 0;
        int xorBenefitCount = 0;
        int minLoss = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorValue = num ^ k;
            totalSum += Math.max(num, xorValue);

            if (xorValue > num) {
                xorBenefitCount++;
                minLoss = Math.min(minLoss, xorValue - num);
            } else {
                minLoss = Math.min(minLoss, num - xorValue);
            }
        }
        if (xorBenefitCount % 2 == 1) {
            totalSum -= minLoss;
        }

        return totalSum;
    }
}