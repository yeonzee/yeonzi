//bfs로 풀려다 실패
//오른쪽, 아래쪽으로만 움직여야 함
//n+1 m+1 배열을 만들어 갈 수 있는 누적 횟수 저장
//그림 그려보면 알 수 있음

import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1000000007;
        
        //누적 횟수 저장할 배열 만들기
        //n+1, m+1하는 이유는 왼쪽, 위쪽 값을 더해야 하기 때문에 맨 왼쪽 줄과 맨 윗줄은 비어놓기 위해
        int[][] map = new int[n+1][m+1];
        
        //물웅덩이는 -1로 표시
        for(int i=0; i<puddles.length; i++) {
            map[puddles[i][1]][puddles[i][0]] = -1;
        }
        
        //집은 1로 초기화
        map[1][1] = 1;
        
        //누적 횟수 채우기
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                
                //물웅덩이면 패스
                if(map[i][j] == -1) {
                    continue;
                }
                //왼쪽 위쪽 값 더하기 (물웅덩이가 아닐 시)
                if(map[i-1][j]>0) {
                    map[i][j] += map[i-1][j] % mod;
                }
                if(map[i][j-1]>0) {
                    map[i][j] += map[i][j-1] % mod;
                }
            }
        }
        return map[n][m] % mod;
    }
}