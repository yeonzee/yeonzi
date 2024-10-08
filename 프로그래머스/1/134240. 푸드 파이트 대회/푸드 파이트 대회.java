//칼로리가 낮은 음식 먼저 배치
import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i=1; i<food.length; i++) {
            int num = food[i] / 2;
            
            for(int j=0; j<num; j++) {
                answer += Integer.toString(i);
            }
        }
        
        answer += "0";
        
        int length = answer.length();
        
        for(int i=length-2; i>=0; i--) {
            answer += Character.toString(answer.charAt(i));
        }
        return answer;
    }
}