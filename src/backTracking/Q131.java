package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Q131 {
    //131.分割回文串
    List<List<String>> ans = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backTrack(s,0);
        return ans;
    }
     public void backTrack(String s, int startIndex){
        if(startIndex >= s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s,startIndex,i)){
                path.add(s.substring(startIndex,i+1));
                backTrack(s,i + 1);
                path.remove(path.size() - 1);
            }
        }
     }

     public boolean isPalindrome(String s, int start, int end){
        while (end >= start){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            end--;
            start++;
        }
        return true;
     }

    public static void main(String[] args) {
        Q131 sol = new Q131();
        System.out.println(sol.partition("aab"));
    }
}
