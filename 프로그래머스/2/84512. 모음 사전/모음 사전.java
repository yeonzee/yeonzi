//재귀를 사용해야만 할 것 같으니 dfs
//StringBuilder을 사용하면 더 효율적
//String을 통해 풀 수도 있지만 지금은 깊이가 5여서 가능한거임. 더 커지면 메모리 효율성 안좋아짐
import java.util.*;
class Solution {
    static int cnt = 0;
    static String[] alpha = {"A","E","I","O","U"};
    static int answer = 0;
    public int solution(String word) {
        
        dfs(word, "", 0);
        
        return answer;
    }
    
    public void dfs(String word, String w, int depth) {
        if(w.equals(word)) {
            answer = cnt;
            return;
        }
        
        if(depth == 5) {
            return;
        }
        
        for(int i=0; i<alpha.length; i++) {
            cnt++;
            dfs(word, w+alpha[i], depth+1);
            //백트래킹이 필요 없는 이유: dfs부를 때 새로운 문자열을 만든 것이기 때문에 본 문자열의 변화는 없다. 그래서 백트래킹으로 원본으로 돌릴 필요 없다.
        }
    }
}