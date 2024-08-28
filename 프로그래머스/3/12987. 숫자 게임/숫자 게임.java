import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int index = 0;
        for(int i=0; i<A.length; i++) {
            if(B[i] <= A[index]) { //지는 경우 무시
                continue;
            }
            answer++;
            index++;
        }
        return answer;
    }
}