import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count_0 = 0;
        int cnt = 0;
        
        while(true) {
            if(s.equals("1")) {
                break;
            }
            
            int len_before = s.length();
            s = s.replaceAll("0","");
            int len = s.length();
            
            s = Integer.toBinaryString(len);
            
            count_0 += len_before - len;
            cnt++;
            
        }
        
        answer[0] = cnt;
        answer[1] = count_0;
        return answer;
    }
}