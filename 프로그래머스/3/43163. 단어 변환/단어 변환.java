//dfs
import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }
    
    public void dfs(String word, String target, String[] words, int depth) {
        //종료조건
        if(word.equals(target)) {
            answer = depth;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            
            //이미 방문했다면 무시
            if(visited[i]) {
                continue;
            }
            
            String w = words[i];
            
            int count = 0;
            for(int j=0; j<w.length(); j++) {
                if(word.charAt(j) != w.charAt(j)) {  //같지 않은게 1개만 있어야 함
                    count++;
                }
            }
            
            if(count==1) {
                visited[i] = true;
                dfs(w, target, words, depth+1);
                visited[i] = false;
            }
        }
        
    }
}