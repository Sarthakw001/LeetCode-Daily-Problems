class Solution {
    public int coinChange(int[] coins, int amount) {
    int INF = amount + 1;

    int[] dp = new int[amount + 1];
    Arrays.fill(dp, INF);

    dp[0] = 0;

    for (int x = 1; x <= amount; x++) {
        for (int coin : coins) {
            if (coin <= x) {
                dp[x] = Math.min(
                    dp[x],
                    dp[x - coin] + 1
                );
            }
        }
    }

    return dp[amount] == INF ? -1 : dp[amount];
}
}