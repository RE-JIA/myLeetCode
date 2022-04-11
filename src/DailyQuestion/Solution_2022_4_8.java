package DailyQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_2022_4_8 {
    public List<List<Integer>> levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Node tmpN = queue.poll();
                tmp.add(tmpN.val);
                for (int i1 = 0; i1 < tmpN.children.size(); i1++) {
                    queue.offer(tmpN.children.get(i1));
                }

            }
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution_2022_4_8 sol = new Solution_2022_4_8();

    }
}
class Node{
    public int val;
    public List<Node> children;

    public Node(){}

    public Node(int _val){
        val = _val;
    }

    public Node(int _val, List<Node> _children){
        val = _val;
        children = _children;
    }
}
