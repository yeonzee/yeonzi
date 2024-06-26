/*dp를 이용하여 풀이
시작지점은 0으로 설정하고 그 이후 도착지점에 1씩 더함. 같은 지점에 도착한 경우는 최소횟수를 구하야 하므로 min을 넣음*/
import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] dp = new int[y+1];
        Arrays.fill(dp,-1);
        dp[x] = 0;
        
        for(int i=x;i<=y;i++) {
            //연산으로 구할 수 없는 값은 무시
            if(dp[i]==-1) {
                continue;
            }
            if(i+n<=y) {
                //더한값이 비어있다면 거기까지 간 횟수를 넣어줌
                if(dp[i+n]==-1) {
                    dp[i+n] = dp[i] +1;
                }
                //이미 거기까지 간 값과 새롭게 간 값 중 더 적은 값을 넣기
                else {
                    dp[i+n] = Math.min(dp[i+n], dp[i]+1);
                }
            }
            
            if(i*2<=y) {
                if(dp[i*2]==-1) {
                    dp[i*2] = dp[i]+1;
                }
                else{
                    dp[i*2] = Math.min(dp[i*2],dp[i]+1);
                }
            }
            
            if(i*3<=y) {
                if(dp[i*3]==-1) {
                    dp[i*3] = dp[i]+1;
                }
                else{
                    dp[i*3] = Math.min(dp[i*3],dp[i]+1);
                }
            }
        }
        return dp[y];
    }
}