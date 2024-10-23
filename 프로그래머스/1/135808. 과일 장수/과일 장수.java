import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        //오름차순 정렬
        Arrays.sort(score);
        
        //큰거부터 넣어야 하기 때문에 뒤에서 부터
        //i>=m -> 남은 사과가 한 상자에 담을 사과보다 많아야 함
        for(int i=score.length; i>=m; i-=m) {
            answer += score[i-m] * m;
        }
    
        return answer;
    }
}
