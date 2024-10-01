//dfs

import java.util.*;
class Solution {
    static boolean[] visited;
    static int answer = 0;
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    public void dfs(String str, String target, String[] words, int depth) {
        
        //종료조건
        if(str.equals(target)) {
            answer = depth;
            return;
        }
        
        for(int i=0; i<words.length; i++) {
            if(!visited[i]) {
                int diff = 0;
                for(int j=0; j<str.length(); j++) {
                    if(str.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }
                if(diff==1) {
                    visited[i] =true;
                    dfs(words[i], target, words, depth+1);
                    //백트래킹
                    visited[i] = false;
                }
            }
        }
        
    }
} 