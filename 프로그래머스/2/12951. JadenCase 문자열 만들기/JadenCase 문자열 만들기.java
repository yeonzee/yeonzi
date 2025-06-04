import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        //마지막 공백 보존
        String[] temp = s.split(" ",-1);
        
        for(String str:temp) {
            
            //공백일 경우 무시
            if(str.length()==0) {
                answer += " ";
                continue;
            }
            
            //첫문자가 숫자
            if(Character.isDigit(str.charAt(0))) {
                answer += str.toLowerCase();
            }
            
            //첫문자만 대문자, 나머지는 소문자
            else {
                str = str.substring(0,1).toUpperCase() + str.substring(1, str.length()).toLowerCase();
                answer += str;
            }
            
            answer += " ";
            
        }

        //마지막 공백 제거
        return answer.substring(0, answer.length() - 1);
    }
}