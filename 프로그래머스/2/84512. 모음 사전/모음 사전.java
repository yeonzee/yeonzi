import java.util.*;
class Solution {
    static String[] alpha = {"A","E","I","O","U"};
    static int cnt = 0;
    static int answer = 0;
    static boolean fin = false;
    public int solution(String word) {
        
        dfs(word, "", 0);
        
        return answer;
    }
    
    public void dfs(String word, String w, int depth) {
        //효율성을 위해 추가적인 재귀함수 호출x
        if(fin) {
            return;
        }
        
        if(w.equals(word)) {
            answer = cnt;
            fin = true;
            return;
        }
        
        if(depth == 5) {
            return;
        }
        
        for(int i=0; i<alpha.length; i++) {
            cnt++;
            dfs(word, w+alpha[i], depth+1);
        }
    }
}