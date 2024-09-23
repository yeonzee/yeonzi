//오른쪽, 아래로만 갈 수 있음
//1,000,000,007로 나눈 나머지
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];
        
        //물웅덩이 -1
        for(int[] temp:puddles) {
            map[temp[1]][temp[0]] = -1;
        }
        
        //집(시작) 1
        map[1][1] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                
                //물웅덩이면 피하기
                if(map[i][j] == -1) {
                    continue;
                }
                
                if(map[i][j-1] > 0) {  //왼쪽에서 올때
                    map[i][j] += map[i][j-1];
                }
                
                if(map[i-1][j] > 0) {  //위쪽에서 올때
                    map[i][j] += map[i-1][j];
                }
                
                //효율성위해 for문 돌때마다 나눠주기
                map[i][j] %= 1000000007;
            }
        }
        
        return map[n][m];
    }
}