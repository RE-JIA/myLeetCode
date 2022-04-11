package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q93 {
    //93. 复原IP地址
    List<String> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        backTrace(s,4,0);
        return ans;
    }

    public void backTrace(String s, int leave, int startIndex){
        if(s.length() - startIndex < leave || s.length() - startIndex > 3*leave){
            return;
        }
        if(leave == 1 && isRule(s.substring(path.get(2)))){
            String tmp = s.substring(0,path.get(0)) + "." +
                    s.substring(path.get(0),path.get(1)) + "." +
                    s.substring(path.get(1),path.get(2)) + "." +
                    s.substring(path.get(2));

            ans.add(tmp);
            return;
        }

        for(int i = startIndex; i < s.length() && i < startIndex + 3; i++){
            if(isRule(s.substring(startIndex, i + 1))){
                path.add(i+1);
                backTrace(s, leave - 1, i + 1);
                path.removeLast();
            }
        }
    }

    public boolean isRule(String s){
        if(s.length() < 1 || s.length() > 3) return false;
        if(s.charAt(0) == '0' && s.length() !=1) return false;
        if(Integer.parseInt(s) > 255) return false;
        return true;
    }

    public static void main(String[] args) {
        Q93 sol = new Q93();
        System.out.println(sol.restoreIpAddresses("123456"));
    }
}
