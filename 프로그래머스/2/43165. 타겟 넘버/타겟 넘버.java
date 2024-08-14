//복습의 복습을 걸쳐,,,,
import java.util.*;
class Solution {
    static int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int depth) {
        
        //종료조건
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return; 
        }
        
        //더하기
        dfs(numbers, target, sum+numbers[depth], depth+1);
        
        //빼기
        dfs(numbers, target, sum-numbers[depth], depth+1);
    }
}