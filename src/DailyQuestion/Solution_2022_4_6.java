package DailyQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_2022_4_6 {
    /*
        310 最小高度树
        medium 对树建立邻接表
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
            return ans;
        }

        int[] degree = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(degree[i] == 1){
                queue.offer(i);
            }
        }
        int leaveNodes = n;
        while (leaveNodes > 2){
            int sz = queue.size();
            leaveNodes -=sz;
            for (int i = 0; i < sz; i++) {
                int tmp = queue.poll();
                for(int a : adj[tmp]){
                    degree[a]--;
                    if(degree[a] == 1){
                        queue.offer(a);
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }
}
