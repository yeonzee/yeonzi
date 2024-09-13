//돌린 상태 유지해야 함
import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] map = new int[rows+1][columns+1];
        
        int num = 1;
        //map 만들기
        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=columns; j++) {
                map[i][j] = num;
                num++;
            }
        }
        
        for(int i=0; i<queries.length; i++) {
            
            int x_1 = queries[i][0];
            int y_1 = queries[i][1];
            int x_2 = queries[i][2];
            int y_2 = queries[i][3];
            
            //시작하는 부분 저장해놓기
            int prev = map[x_1][y_1];
            int min = Integer.MAX_VALUE;
            
            //오른쪽으로 회전
            for(int j=y_1+1; j<=y_2; j++) {
                int temp = map[x_1][j];
                map[x_1][j] = prev;
                min = Math.min(min, prev);
                prev = temp;
            }
            
            //아래로 회전
            for(int j=x_1+1; j<=x_2; j++) {
                int temp = map[j][y_2];
                map[j][y_2] = prev;
                min = Math.min(min, prev);
                prev = temp;
            }
            
            //왼쪽으로 회전
            for(int j=y_2-1; j>=y_1; j--) {
                int temp = map[x_2][j];
                map[x_2][j] = prev;
                min = Math.min(min, prev);
                prev = temp;
            }
            
            //위로 회전
            for(int j=x_2-1; j>=x_1; j--) {
                int temp = map[j][y_1];
                map[j][y_1] = prev;
                min = Math.min(min, prev);
                prev = temp;
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
}