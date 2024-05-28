import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
       
        // int[] 배열을 오름차순으로 정렬
        Arrays.sort(score);
        
        // m 크기만큼 잘라서 배열 복사
        int count = score.length / m;
        int idx = score.length;
        
        while(count > 0) {
            //Integer.MAX_VALUE -> int중 가장 큰 값
            int minValue = Integer.MAX_VALUE;
            
            // 현재 그룹에서 최소값 찾기
            for (int i = idx - m; i < idx; i++) {
                if (score[i] < minValue) {
                    minValue = score[i];
                }
            }
            
            answer += minValue * m;
            idx -= m;
            count--;
        }
        
        return answer;
    }
}
