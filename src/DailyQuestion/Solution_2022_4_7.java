package DailyQuestion;

public class Solution_2022_4_7 {
    /*
        769 旋转字符串
        esay 字符串类型
     */
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if(n != goal.length()) return false;

        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == goal.charAt(0)){
                if(s.substring(i,n).equals(goal.substring(0,n-i)) && s.substring(0,i).equals(goal.substring(n-i,n))){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution_2022_4_7 sol = new Solution_2022_4_7();
        String s = "abcde";
        String goal = "bcdae";
        System.out.println(sol.rotateString(s,goal));
    }
}
