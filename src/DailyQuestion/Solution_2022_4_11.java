package DailyQuestion;

public class Solution_2022_4_11 {
    public int countNumbersWithUniqueDigits(int n){
        if(n == 0) return 1;
        if(n == 1) return 10;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        for(int i = 2; i <= n; i++){
            int tmp = 9;
            for(int j = 1; j < i; j++){
                tmp *= (10 - j);
            }
            dp[i] = tmp;
        }
        int ans = 0;
        for(int t : dp){
            ans += t;
        }
        return ans;
    }
}
