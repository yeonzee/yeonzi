//왼쪽으로 밀어서 누적값 저장
//누적값은 위에 있는 값 중 큰 값으로 가져오기

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] map = new int[triangle.length][triangle.length];
        
        map[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                //첫번째 열은 바로 위의 값만 받을 수 있다
                if(j==0) {
                    map[i][j] = map[i-1][j] + triangle[i][j];
                }
                
                //마지막 열은 대각선 위의 값만 받을 수 있다
                else if(j==i) {
                    map[i][j] = map[i-1][j-1] + triangle[i][j];
                }
                
                //중간 값들은 더 큰 값을 받을 수 있다
                else {
                    map[i][j] = Math.max(map[i-1][j], map[i-1][j-1]) + triangle[i][j];
                }
            }
        }
        
        //마지막 열에서 가장 큰 값
        for(int i=0; i<triangle.length; i++) {
            answer = Math.max(answer, map[triangle.length-1][i]);
        }
        
        return answer;
    }
}