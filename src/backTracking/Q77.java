package backTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77 {
    /*
        77.组合
     */
    List<List<Integer>> ans = new ArrayList<>();
    LinkedList<Integer> tmpRes = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backTrack(k,1,n);
        return ans;
    }
    //确定回溯参数
    void backTrack(int k, int start, int end){
        if(tmpRes.size() == k){
            List<Integer> tmp = new ArrayList<>(tmpRes);
            ans.add(tmp);
            return;
        }
        for(int i = start; i <= end; i++){
            tmpRes.add(i);
            backTrack(k,i+1,end);
            tmpRes.removeLast();
        }
    }

    public static void main(String[] args) {
        Q77 sol = new Q77();
        System.out.println(sol.combine(5,3));
    }
}
