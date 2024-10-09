//s1, d2, t3
//*->해당 점수 2배,직전 점수 2배, #->해당 점수 마이너스

import java.util.*;
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        //순서대로 값을 저장할 배열
        int[] result = new int[3];
        int idx = 0;
        int num = 0;
        
        for(int i=0; i<dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            //숫자인지 확인
            if(Character.isDigit(ch)) {
                //10인 경우에는 2자리수이므로 따로 계산
                if(ch=='1' && dartResult.charAt(i+1)=='0') {
                    num = 10;
                    i++;
                }
                else {
                    num = Character.getNumericValue(ch);
                }
            }
            
            //s,d,t 제곱해서 넣기
            else if(ch=='S') {
                result[idx] = (int)Math.pow(num,1);
                idx++;
            }
            else if(ch=='D') {
                result[idx] = (int)Math.pow(num,2);
                idx++;
            }
            else if(ch=='T') {
                result[idx] = (int)Math.pow(num,3);
                idx++;
            }
            
            //*,#일 경우 계산
            else if(ch=='*') {
                //*가 2개 이상일 경우
                if(idx>1) {
                    result[idx-2] *= 2;  //직전 *2
                }
                result[idx-1] *= 2;  //현재 *2
            }
            
            else if(ch=='#') {
                result[idx-1] *= -1;
            }
        }
        
        for(int n:result) {
            answer += n;
        }
        
        return answer;
    }
}