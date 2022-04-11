package dp;

public class Q494 {
    //494 目标和
    public int findTargetSumWays(int[] nums, int target){
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int n = nums.length;
        int[][]dp = new int[2*sum+1][n+1];
        dp[sum][0] = 1;
        for(int j = 1; j <= n; j++){
            for(int i = 0; i < nums[j-1]; i++){
                dp[i][j] = dp[i + nums[j-1]][j-1];
            }
            for(int i = nums[j-1]; i <= 2*sum - nums[j-1]; i++){
                dp[i][j] = dp[i + nums[j-1]][j-1] + dp[i - nums[j-1]][j-1];
            }

            for(int i = 2*sum+1 - nums[j-1]; i <= 2*sum; i++){
                dp[i][j] = dp[i - nums[j-1]][j-1];
            }
        }
        if(target > sum || target < -1*sum) return 0;
        return dp[target + sum][n];
    }
}
