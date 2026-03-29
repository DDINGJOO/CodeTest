class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total || ((total + target) & 1) == 1) {
            return 0;
        }
        int positiveSum = (total + target) / 2;
        
        
        int[] dp = new int[positiveSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int sum = positiveSum; sum >= num; sum--) {
                dp[sum] += dp[sum - num];
            }
        }

        return dp[positiveSum];
    }
}
