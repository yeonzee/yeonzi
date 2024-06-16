//내가 푼 거
import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left) + 1;
        int[] answer = new int[length];
        
        for (int i=0 ; i<length ; i++) {
            long index = left + i;
            int a = (int)(index / n);
            int b = (int)(index % n);
            
            answer[i] = Math.max(a,b) + 1;
        }
        
        return answer;
    }
}