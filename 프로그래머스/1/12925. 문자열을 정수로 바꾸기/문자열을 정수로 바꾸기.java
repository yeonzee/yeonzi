import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        //음수라면
        if(s.charAt(0) == '-') {
            answer = Integer.valueOf(s.substring(1)) * -1;
        }
        
        //양수라면
        else {
            answer = Integer.valueOf(s);
        }
        
        return answer;
    }
}