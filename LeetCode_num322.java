package Array.num322;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length==0)
            return -1;
        if (amount==0)
            return 0;
        Arrays.sort(coins);
        if (amount<coins[0])
            return -1;
        int dp[]=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        dp[coins[0]]=1;
        for (int i = coins[0]+1; i < dp.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i-coins[j]>=1) dp[i]=Math.min(dp[i-coins[j]]+1,dp[i]);
                else if (i%coins[j]==0) dp[i]=Math.min(i/coins[j],dp[i]);
                else break;
            }
        }
        return dp[amount]==Integer.MAX_VALUE-1?-1:dp[amount];
    }
}
