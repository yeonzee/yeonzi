import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int cnt_0 = 0;
        while(!s.equals("1")) {
            int len_before = s.length();
            
            s = s.replaceAll("0","");
            int len_after = s.length();
            
            cnt_0 += len_before - len_after;
            s = Integer.toBinaryString(len_after);
            count++;
        }
        
        answer[0] = count;
        answer[1] = cnt_0;
        
        return answer;
    }
}