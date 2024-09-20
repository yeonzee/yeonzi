//dfs
import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(0, dungeons, k);
        
        return answer;
    }
    
    public void dfs(int depth, int[][] dungeons, int k) {
        
        for(int j=0; j<dungeons.length; j++) {
            if(!visited[j] && k>=dungeons[j][0]) {
                visited[j] = true;
                k -= dungeons[j][1];
                dfs(depth+1, dungeons, k);
                
                //백트래킹
                visited[j] = false;
                k += dungeons[j][1];
            }
        }
        
        answer = Math.max(answer, depth);
    }
}