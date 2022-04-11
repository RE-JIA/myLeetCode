package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216 {
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(k,n,1);
        return ans;
    }

    public void backTrack(int k, int target, int index){

        if(path.size() == k){
            if(target == 0)
                ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i <= 9; i++){
            path.add(i);
            backTrack(k, target- i, i + 1);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Q216 sol = new Q216();
        System.out.println(sol.combinationSum3(3,13));
    }
}
