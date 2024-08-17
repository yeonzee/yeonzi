//최소단계여서 bfs로 구하려다가 실패
//dfs 풀이
import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String begin, String target, String[] words, int count) {
        //종료조건
        if(begin.equals(target)) {
            answer = count;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            //방문한 경우 무시
            if(visited[i]) {
                continue;
            }
            
            //다른 글자 수 세기
            int k = 0;
            for(int j=0; j<words[i].length(); j++) {
                if(begin.charAt(j) != words[i].charAt(j)) {
                    k++;
                }
            }
            
            //한글자만 다른 경우 단어 바꾸기
            if(k==1) {
                visited[i] = true;
                dfs(words[i], target, words, count+1);
                //백트래킹
                visited[i] = false;
            }
        }
        
    }
}