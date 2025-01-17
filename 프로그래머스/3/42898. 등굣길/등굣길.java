//오른쪽과 아래쪽으로만 이동 / 1000000007로 나눈 나머지
//해당 칸에 접근할 수 있는 방법 갯수 누적하기
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n+1][m+1];
        int mod = 1000000007;
        
        //물웅덩이 -1
        for(int[] temp:puddles) {
            map[temp[1]][temp[0]] = -1;
        }
        
        //시작
        map[1][1] = 1;
        
       for(int i=1; i<=n; i++) {
           for(int j=1; j<=m; j++) {
               //물웅덩이 만나면 패스
               if(map[i][j] == -1) {
                   continue;
               }
               //아래로 이동
               if(map[i-1][j] > 0) {
                   map[i][j] += map[i-1][j] % mod;
               }
               //오른쪽으로 이동
               if(map[i][j-1] > 0) {
                   map[i][j] += map[i][j-1] % mod;
               }
           }
       } 
        return map[n][m] % mod;
    }
}