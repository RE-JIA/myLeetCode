package DailyQuestion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution_2022_4_5 {
    /*
        762.二进制表示中质数个计算置位
     */
    int[][] dp = new int [20][21];
    {
        dp[0][1] = 1;
        for (int i = 1; i < 20; i++) {
            dp[i][1] = 1;
            for (int j = 2; j <= i; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
            dp[i][i+1] = 1;
        }
        System.out.println(Arrays.deepToString(dp));
    }
    Set<Integer> PrimeSet = new HashSet<>();
    {
        PrimeSet.add(2);
        PrimeSet.add(3);
        PrimeSet.add(5);
        PrimeSet.add(7);
        PrimeSet.add(11);
        PrimeSet.add(13);
        PrimeSet.add(17);
        PrimeSet.add(19);
    }
    public int countPrimeSetBits(int left, int right){
        /*
            题目规定 left，right小于pow(10,6),换算成二进制即pow(2,20);
            即二进制表示中长度最多为20位
            20以内的质数有2、3、5、7、11、13、17、19;
         */
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if(PrimeSet.contains(countBits(i))){
                ans++;
            }
        }
        return ans;
    }

    public int countBits(int num){
        int tmp = num;
        int ans = 0;
        while (tmp != 0){
            if(tmp%2==1)ans+=1;
            tmp /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_2022_4_5 sol = new Solution_2022_4_5();
        System.out.println(sol.countPrimeSetBits(10,15));
    }
}
