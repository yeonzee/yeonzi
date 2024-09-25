//dfs
import java.util.*;
class Solution {
    static int cnt = 0;
    static boolean[] visited;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        visited = new boolean[numbers.length];
        
        dfs(0, numbers, target, 0);
        
        return cnt;
    }
    
    public void dfs(int depth, int[] numbers, int target, int num) {
        
        //종료조건
        if(depth==numbers.length) {
            if(num==target) {
                cnt++;
            }
            return;
        }
    
        //더하기
        dfs(depth+1, numbers, target, num+numbers[depth]);
        //빼기
        dfs(depth+1, numbers, target, num-numbers[depth]);
    }
}