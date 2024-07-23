//첨부터 number의 길이 그룹을 만들어 그 그룹 내에서 큰 값 찾기
//주의할 점: 큰 값을 찾아낸 다음의 큰 값을 골라야 한다
import java.util.*;
class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        //만들 문자의 길이
        int len = number.length() - k;
        
        //찾아낸 큰 값의 다음 값부터 구해야하기 때문에 start란 변수 만들기
        int start = 0;
        for(int i=0; i<len; i++) {
            //가장 작은 값
            char max = '0';
            for(int j=start; j<=i+k; j++) {
                if(number.charAt(j)>max) {
                    max = number.charAt(j);
                    start = j+1;
                }
                
                //시간 효율성을 위해 가장 큰 수인 9면 스탑
                if(max == '9') {
                    break;
                }
            }
            answer += Character.toString(max);
        }

        return answer;
    }
}