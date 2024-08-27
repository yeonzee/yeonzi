//문제 이상함 n,m 반대임
import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] map = new int[n+1][m+1];
        
        //물웅덩이 -1으로 만들기
        for(int i=0; i<puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        //집 1로 초기화
        map[1][1] = 1;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                
                //물웅덩이 무시
                if(map[i][j] == -1) {
                    continue;
                }
                
                if(map[i-1][j]>0) {  //위쪽에서 오는 값이 있다면
                    map[i][j] += map[i-1][j];
                }
                
                if(map[i][j-1]>0) {  //왼쪽에서 오는 값이 있다면
                    map[i][j] += map[i][j-1];
                }
                
               map[i][j]  %= 1000000007;
            }
        }
        return map[n][m];
    }
}