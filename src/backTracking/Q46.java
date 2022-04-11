package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q46 {
    //46.全排列
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums){
        int n = nums.length;
        boolean[] flags = new boolean[n];
        Arrays.fill(flags,true);
        backTrace(nums,flags,0);
        return ans;
    }

    public void backTrace(int[] nums, boolean[] flags, int startIndex){
        if(startIndex == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(flags[i]){
                flags[i] = false;
                path.add(nums[i]);
                backTrace(nums,flags,startIndex + 1);
                path.removeLast();
                flags[i] = true;
            }
        }
    }

    public static void main(String[] args) {
        Q46 sol = new Q46();
        int[] nums = {1,2,3};
        System.out.println(sol.permute(nums));
    }
}
