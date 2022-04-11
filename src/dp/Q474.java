package dp;

public class Q474 {
    //474 一和零
    public int findMaxForm(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        int len = strs.length;
        for(String str: strs){
            int tn = find1Num(str);
            int tm = str.length() - tn;
            for(int i = m; i >= tm; i--){
                for(int j = n; j >= tn; j--){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - tm][j - tn]);
                }
            }
        }
        return dp[m][n];
    }

    public int find1Num(String s){
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '1'){
                ans ++;
            }
        }
        return ans;
    }
}
