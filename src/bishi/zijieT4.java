package bishi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class zijieT4 {
    public static void main(String[] args) {
        int a = 3;
        int n = 7;
        String[] strs = {"000","111","222","345","686","891","101"};
        int[][] dp = new int[n+1][1025];
        for(int[] t : dp){
            Arrays.fill(t,10000);
        }
        dp[0][0] = 0;
        for(int i = 1; i <= n ;i++){
            int tmp = convertToInt(strs[i-1]);
            System.out.println(tmp);
            for(int j = 0; j <= 1023; j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i-1][j]);
            }
            for(int j = 0; j <= 1023; j++){
                dp[i][j|tmp] = Math.min(Math.min(dp[i-1][j|tmp],dp[i-1][j]+1),dp[i][j|tmp]);
            }
        }
        System.out.println(dp[7][1023]);

    }
    public static int convertToInt(String a){
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }
        int ans = 0;
        for(char c : set){
            ans += Math.pow(2,c-'0');
        }
        return ans;
    }
}
