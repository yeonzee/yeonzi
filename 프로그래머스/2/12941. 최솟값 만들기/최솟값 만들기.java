//A는 오름차순, B는 내림차순으로 해서 곱하기
import java.util.*;
class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[A.length-i-1];
        }

        return answer;
    }
}