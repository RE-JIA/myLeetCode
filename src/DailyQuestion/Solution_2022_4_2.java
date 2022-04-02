package DailyQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_2022_4_2 {
    /*

     */
    public static int strongPasswordChecker(String password){
        //n:应处理的字符长度
        int n = password.length();

        //强密码至少包含一个小写字母(a-z)、一个大写字母(A-Z)，和一个数字(0-9)。
        //requireChar 指当前密码缺的字符种类
        int requireChar = 3;

        //continuousChar 存放连续字符长度
        List<Integer> continuousChar = new ArrayList<>();
        boolean[] requireCharFlag = new boolean[3];
        Arrays.fill(requireCharFlag,true);
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            //判断缺少的字符种类
            if(password.charAt(i) - '0' >=0 && password.charAt(i) - '0' <= 9 && requireCharFlag[0]){
                requireChar--;
                requireCharFlag[0] = false;
            }else if(password.charAt(i) - 'a' >=0 && password.charAt(i) - 'a' <= 25 && requireCharFlag[1]){
                requireChar--;
                requireCharFlag[1] = false;
            }else if(password.charAt(i) - 'A' >=0 && password.charAt(i) - 'A' <= 25 && requireCharFlag[2]){
                requireChar--;
                requireCharFlag[2] = false;
            }
            //找出字符串中连续的字符，并将结果存入continuousChar中
            if(i > 0){
                if(password.charAt(i) != password.charAt(i-1)){
                    if(i - 1 - startIndex >=2){
                        continuousChar.add(i - startIndex);
                    }
                    startIndex = i;
                }
                if(i == n-1 && password.charAt(i) == password.charAt(i-1)){
                    if(i - startIndex >=2){
                        continuousChar.add(i - startIndex + 1);
                    }
                }
            }
        }
        //分成三种情况，n<6; 6=<n<=20; n>20
        if(n < 6){
            /* n<6时有三种情况
            n <= 3时，补齐字符到长度6即可
            n=4时，若缺的字符种类数为3，则说明只有. ！这些字符，所以最小修改次数为3
                   若缺的字符种类数为2，那么只修改两次即可。
            n=5时，若所缺字符数<=1,返回1，否则返回2
             */
            if(n <= 3) return 6 - n;
            else if(n == 4){
                if(requireChar == 3) return 3;
                else return 2;
            }else {
                if(requireChar <= 1)return 1;
                else return 2;
            }
        }else if(n <= 20){
            /*n在6-20内情况较简单
                连续相同字符数量是3的倍数时，需要每隔两个字符进行一次替换，且替换时观察所要求字符是否已经全部拥有。
                返回max(连续字符需替换次数, 缺少要求字符种类数)
             */
            int ans = 0;
            for(int i = 0; i < continuousChar.size(); i++){
                ans += (continuousChar.get(i))/3;
            }
            return Math.max(ans,requireChar);
        }else{
            /* n>20时情况较为复杂

             */
            int limit = n -20;
            int ans = 0;
            int t_flag = 0;
            boolean f = true;
            while( (limit > 0) && f){
                f = false;
                for(int i = 0; i < continuousChar.size(); i++){
                    if(t_flag%3==0){
                        if(limit > 0){
                            if(continuousChar.get(i)%3==0){
                                continuousChar.set(i,continuousChar.get(i) - 1);
                                limit--;
                                ans++;
                            }
                        }
                    }else if(t_flag%3 == 1){
                        if(limit > 0){
                            if(continuousChar.get(i)%3==1){
                                if(limit == 1){
                                    continuousChar.set(i,continuousChar.get(i) - 1);
                                    limit--;
                                    ans++;
                                }else{
                                    continuousChar.set(i,continuousChar.get(i) - 2);
                                    limit -=2;
                                    ans += 2;
                                }
                            }
                        }
                    }else{
                        if(limit > 0){
                            if(continuousChar.get(i)%3==2 && continuousChar.get(i)>3){
                                if(limit <= 3){
                                    continuousChar.set(i,continuousChar.get(i) - limit);
                                    ans += limit;
                                    limit = 0;

                                }else{
                                    continuousChar.set(i,continuousChar.get(i) - 3);
                                    limit -= 3;
                                    ans += 3;
                                }
                            }
                        }
                    }
                    if(continuousChar.get(i) >=3){
                        f = true;
                    }
                }
                t_flag++;
            }
            if(limit > 0){
                return ans + limit + requireChar;
            }
            int tmp_ans = 0;
            for(int i = 0; i < continuousChar.size(); i++){
                tmp_ans += continuousChar.get(i)/3;
            }

            if(tmp_ans >= requireChar)return ans+tmp_ans;
            else{
                return ans+requireChar;
            }
        }
    }

    public static void main(String[] args) {
        String test = "ABABABABABABABABABAB1";
        System.out.println(strongPasswordChecker(test));
    }
}
