import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        
        int start = 0;
        //뽑아야 하는 자릿수 만큼 반복
        for(int i=0; i<number.length()-k; i++) {
            char max = '0';
            for(int j=start; j<i+k+1; j++) {
                //큰 수 찾기
                if(max<number.charAt(j)) {
                    max = number.charAt(j);
                    start = j+1;
                }
                //효율성을 위해 제일 큰 수((9)라면 끝내버리기
                if(max == '9') {
                    break;
                }
            }
            
            answer += Character.toString(max);
        }
        return answer;
    }
}