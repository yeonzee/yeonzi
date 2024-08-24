//삼각형 왼쪽으로 밀기
//합에 대한 배열 만들기
import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] arr = new int[triangle.length][triangle.length];
        
        arr[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<triangle[i].length; j++) {
                //첫번째 값은 위에 값만 더해야 함
                if(j==0) {
                    arr[i][j] = arr[i-1][j] + triangle[i][j];
                }
                //마지막 값은 윗 대각선의 값만 더해야 함
                else if(j==triangle[i].length-1) {
                    arr[i][j] = arr[i-1][j-1] + triangle[i][j];
                }
                else { //두개 다 아니라면 위에 있는 값 중 큰 값을 더해야 함
                    arr[i][j] = Math.max(arr[i-1][j], arr[i-1][j-1]) + triangle[i][j];
                }   
            } 
        }
        
        for(int k=0; k<triangle.length; k++) {
            answer = Math.max(answer, arr[triangle.length-1][k]);
        }
        return answer;
    }
}