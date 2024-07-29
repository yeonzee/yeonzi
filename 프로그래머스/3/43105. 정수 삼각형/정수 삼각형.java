//스스로 풀었습니다 감격의 눈물파티 on
//삼각형을 왼쪽으로 민다

import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        //triangle의 길이만큼 빈 배열 생성해서 누적값 저장
        int[][] sum = new int[triangle.length][triangle.length];
        
        //누적값의 처음 값은 triangle의 처음 값 대입
        sum[0][0] = triangle[0][0];
        
        for(int i=1; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                //j가 0보다 클 때는 내 위에 있는 누적 값 중 큰 값을 골라서 더해야 함
                if(i>0 && j>0) {
                    sum[i][j] = Math.max(sum[i-1][j-1],sum[i-1][j]) + triangle[i][j];
                }
                //j가 0일 경우엔 무조건 내 위에 있는 누적값에서 더해야 함
                else {
                    sum[i][j] = sum[i-1][j] + triangle[i][j];
                }
            }
        }
        
        //sum의 마지막 줄에서 최댓값 뽑기
        for(int i=0; i<triangle.length; i++) {
            answer = Math.max(answer, sum[triangle.length-1][i]);
        }
        return answer;
    }
}