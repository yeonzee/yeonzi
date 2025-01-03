//dfs
import java.util.*;
class Solution {
    static int answer;
    static boolean[] checked;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        checked = new boolean[dungeons.length];
        
        dfs(0, dungeons, k);
            
        return answer;
    }
    
    public void dfs(int depth, int[][] dungeons, int k) {
        
        for(int i=0; i<dungeons.length; i++) {
            //조건을 충족한다면 탐험
            if(k>=dungeons[i][0] && !checked[i]) {
                //방문처리
                checked[i] = true;
                k -= dungeons[i][1];
                dfs(depth+1, dungeons, k);
                
                //백트래킹
                checked[i] = false;
                k += dungeons[i][1];
            }
        }
        
        answer = Math.max(answer,depth);
    }
}