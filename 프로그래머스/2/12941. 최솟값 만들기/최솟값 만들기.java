import java.util.*;
class Solution {
    public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);  //오름차순
        Arrays.sort(B);  
        
        for(int i=0; i<A.length; i++) {
            answer += A[i] * B[B.length-i-1];
        }

        return answer;
    }
}