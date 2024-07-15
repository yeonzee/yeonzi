import java.util.*;
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        return dfs(0,target,numbers,0);
        
    }
    
    public int dfs(int depth, int target, int[] numbers, int sum) {
        
        int count = 0;
            
        //한 줄기 탐색 끝
        if(depth == numbers.length) {
            //탐색 후 더한 값이 target과 같다면
            if(sum == target) {
                return 1;
            }
            else {
                return 0;
            }
        }

        //값을 더하는 경우
        count += dfs(depth+1, target, numbers, sum+numbers[depth]);

        //값을 빼는 경우
        count += dfs(depth+1, target, numbers, sum-numbers[depth]);

        return count;

        
    }
}