//dfs
import java.util.*;
class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(0, numbers, target, 0);
        return answer;
    }
    
    public void dfs(int depth, int[] numbers, int target, int num) {
        
        //종료조건
        if(depth == numbers.length) {
            if(num == target) {
                answer++;
            }
            return;
        }
        
        //더하기
        dfs(depth+1, numbers, target, num+numbers[depth]);
        //빼기
        dfs(depth+1, numbers, target, num-numbers[depth]);
    }
}