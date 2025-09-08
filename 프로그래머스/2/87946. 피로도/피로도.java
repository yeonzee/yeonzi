import java.util.*;
class Solution {
    static int answer;
    static boolean[] check;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        check = new boolean[dungeons.length];
        
        dfs(dungeons, 0, k);
        return answer;
    }
    
    public void dfs(int[][] dungeons, int depth, int k) {
        
        for(int i=0; i<dungeons.length; i++) {
            //탐색 가능 = 방문하지 않았고 남은 피로도 가능
            if(!check[i] && dungeons[i][0] <= k) {
                //방문처리
                check[i] = true;
                k -= dungeons[i][1];
                dfs(dungeons, depth+1, k);
                
                //백트래킹
                check[i] = false;
                k += dungeons[i][1];
            }
        }
        
        answer = Math.max(answer, depth);
    }
}