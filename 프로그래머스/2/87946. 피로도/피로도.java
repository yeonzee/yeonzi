//dfs
import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(0,k,dungeons);
        
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        // if(dungeons.length == depth) {
        //     return;
        // }
        
        for(int i=0; i<dungeons.length; i++) {
            //k보다 작고 방문하지 않았다면 탐방 가능
            if(k>=dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                //다시 탐험
                dfs(depth+1, k-dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(answer,depth);
    }
}