package backTracking;

import java.util.*;

public class Q40 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    Set<Set<Integer>> res = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0);
        return ans;
    }

    public void backTrack(int[] candidates, int target, int startIndex){
        if(target == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 ){
            return;
        }

        for(int i = startIndex; i < candidates.length; i++){
            if(candidates[i] > target){
                continue;
            }
            if(i > startIndex && candidates[i] == candidates[i - 1]){
                continue;
            }
            path.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Q40 sol = new Q40();
        int[] candidates = {10,1,2,7,6,1,5};

        System.out.println(sol.combinationSum2(candidates,8));
    }
}
