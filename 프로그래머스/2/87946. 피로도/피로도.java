import java.util.*;
class Solution {
    static boolean[] check;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        check = new boolean[dungeons.length]; 
        
        dfs(0, k, dungeons);
        
        return answer;
    }
    
    public void dfs(int depth, int k, int[][] dungeons) {
        
        for(int i=0; i<dungeons.length; i++) {
            //탐험 가능
            if(k>=dungeons[i][0] && !check[i]) {
                check[i] = true;
                k -= dungeons[i][1];
                dfs(depth+1, k, dungeons);
                
                //백트래킹
                check[i] = false;
                k += dungeons[i][1];
            }
        }
        
        answer = Math.max(answer,depth);
    }
    
}