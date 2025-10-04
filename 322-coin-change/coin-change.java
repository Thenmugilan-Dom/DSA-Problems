class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1; 
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max); 
        dp[0] = 0;

        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] = Math.min(dp[x], dp[x - coin] + 1);
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
