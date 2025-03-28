//dp 풀이
import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        int[] dp = new int[y+1];
        Arrays.fill(dp,-1);
        
        //시작
        dp[x] = 0;
        
        for(int i=x; i<=y; i++) {
            //도달할 수 없는 숫자면 패스
            if(dp[i] == -1) {
                continue;
            }
        
            //+n
            if(i+n <= y) {
                //아직 도달하지 않은 숫자라면
                if(dp[i+n] == -1) {
                    dp[i+n] = dp[i]+1;
                }
                //이미 도달해있는 숫자라면 최솟값
                else {
                    dp[i+n] = Math.min(dp[i+n], dp[i]+1);
                }
            }
            
            //*2
            if(i*2 <= y) {
                if(dp[i*2] == -1) {
                    dp[i*2] = dp[i]+1;
                }
                else {
                    dp[i*2] = Math.min(dp[i*2], dp[i]+1);
                }
            }
            
            //*3
            if(i*3 <= y) {
                if(dp[i*3] == -1) {
                    dp[i*3] = dp[i]+1;
                }
                else {
                    dp[i*3] = Math.min(dp[i*3], dp[i]+1);
                }
            }
        }
        
        return dp[y];
    }
}