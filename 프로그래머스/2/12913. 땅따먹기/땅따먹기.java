//같은 열을 제외한 가장 큰 값을 누적
import java.util.*;
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        for(int i=1; i<land.length; i++) {
            land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2],land[i-1][3]));
            land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2],land[i-1][3]));
            land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][3]));
            land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1],land[i-1][2]));
        }
        
        //마지막 행에서 가장 큰 값
        for(int j=0; j<4; j++) {
            answer = Math.max(answer, land[land.length-1][j]);
        }

        return answer;
    }
}