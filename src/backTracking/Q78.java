package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q78 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        List<Integer> set = new ArrayList<>();
        backTrace(nums,0,set);
        return ans;
    }
    public void backTrace(int[] nums, int startIndex, List<Integer> set){
        if(startIndex == nums.length){
            ans.add(set);
            return;
        }
        List<Integer> tmp1 = new ArrayList<>(set);
        List<Integer> tmp2 = new ArrayList<>(set);
        tmp2.add(nums[startIndex]);
        backTrace(nums,startIndex+1,tmp1);
        backTrace(nums,startIndex+1,tmp2);
    }

    public static void main(String[] args) {
        Q78 sol = new Q78();
        int[] nums = {1,2,3,4};
        System.out.println(sol.subsets(nums));
    }
}
