import java.util.*;
class Solution {
    public int[] solution(long n) {
        
        //길이를 구하기 위해 str로 변환
        String s = String.valueOf(n);
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            answer[i] = (int)(n%10);
            n /= 10;
        }
        return answer;
    }
}