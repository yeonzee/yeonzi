import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs,(int[] o1, int[] o2) -> o1[2]-o2[2]);
        
        parent = new int[n];
        
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int total = 0;
        for(int[] edge: costs) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            
            int fromParent = findParent(from);
            int toParent = findParent(to);
            
            if(fromParent == toParent) {
                continue;
            }
            
            total += cost;
            parent[toParent] = fromParent;
        }
        return total;
    }
    
    public int findParent(int node) {
        if(parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node]);
    }
}