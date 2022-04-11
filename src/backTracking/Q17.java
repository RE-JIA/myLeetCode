package backTracking;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    List<String> ans = new ArrayList<>();
    StringBuffer path = new StringBuffer();
    List<String> character = new ArrayList<>();
    {
        character.add("abc");
        character.add("def");
        character.add("ghi");
        character.add("jkl");
        character.add("mno");
        character.add("pqrs");
        character.add("tuv");
        character.add("wxyz");

    }
    public List<String> letterCombinations(String digits) {
        backTrace(0,digits.length(),digits);
        return ans;
    }

    public void backTrace(int start, int end , String digits){
        if(path.length() == digits.length()){
            ans.add(path.toString());
        }
        for(int i = start; i < end; i++){
            int n = digits.charAt(i) - '2';
            for(int j = 0; j < character.get(n).length(); j++){
                path.append(character.get(n).charAt(j));
                backTrace(i + 1, end, digits);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Q17 sol = new Q17();
        System.out.println(sol.letterCombinations("2345"));
    }
}
