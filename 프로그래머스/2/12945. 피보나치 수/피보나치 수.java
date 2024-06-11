//피보나치 수 -> 배열 활용
import java.util.*;
class Solution {
    public int solution(int n) {
        int[] answer = new int[n+1];
        answer[0] = 0;
        answer[1] = 1;
        
        for (int i=2;i<=n;i++) {
            //피보나치 수는 int형과 long형보다 훨씬 크기 때문에 1234567로 나누어주지 않으면 오버플로우 발생 -> 오류엔딩
            //모듈러 연산 사용
            answer[i] = (answer[i-1] + answer[i-2])%1234567; 
        }
        
        return answer[n] % 1234567;
    }
}