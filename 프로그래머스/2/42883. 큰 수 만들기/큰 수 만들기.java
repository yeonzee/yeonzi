import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        int start = 0;
        for(int i=0; i<number.length()-k; i++) {
            char max = '0';
            for(int j=start; j<i+k+1; j++) {
                if(number.charAt(j) > max) {
                    max = number.charAt(j);
                    start = j+1;
                }
                
                //시간 효율성을 위해 가장 큰 수인 9면 스탑
                if(number.charAt(j) == '9') {
                    break;
                }
            }
            answer += Character.toString(max);
        }
        return answer;
    }
}