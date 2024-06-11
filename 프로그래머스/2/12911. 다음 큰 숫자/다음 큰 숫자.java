/*
효율성을 높이기 위해서는 while문 밖에서 계산할 수 있는 건 최대한 밖에서 하기
*/
import java.util.*;
class Solution {
    public int solution(int n) {
        int n_len = Integer.bitCount(n);
        
        int answer = n+1;
        
        while(true) {
            int ans_len = Integer.bitCount(answer);
            
            if (n_len == ans_len) {
                break;
            }
            answer++;
        }
        return answer;
    }
}