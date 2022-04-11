package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q39 {
    //39 组合总和
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(candidates,target, 0);
        return ans;
    }

    public void backTrace(int[] candidates, int target, int startIndex){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        int n = candidates.length;
        for (int i = startIndex; i < n; i++) {
            path.add(candidates[i]);
            backTrace(candidates,target - candidates[i], i);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Q39 sol = new Q39();
        int[] candidates = {2,3,6,7};
        System.out.println(sol.combinationSum(candidates,7));
    }
}
