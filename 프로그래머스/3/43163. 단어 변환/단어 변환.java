//dfs 풀이
import java.util.*;
class Solution {
    static int answer;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        visited = new boolean[words.length];
        dfs(0,begin,target,words);
        return answer;
    }
    
    public void dfs(int cnt, String begin, String target, String[] words) {
        
        
        //종료조건
        if(begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            //이미 방문한 곳이라면 안간다
            if(visited[i]) {
                continue;
            }
        
            int k=0;
            //한글자만 다를 경우
            for(int j=0;j<begin.length();j++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    k++;
                }
            }
            
            //k가 1인 경우(바꾸는 경우)
            if(k==1) {
                visited[i] = true;
                dfs(cnt+1,words[i],target,words);
                visited[i] = false;
            }
        }
    }
}