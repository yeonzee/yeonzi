import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        
        //마지막 공백 보존
        String[] tmp = s.split(" ",-1);
        
        for(String str:tmp) {
            
            //str이 공백이 아닌 경우 && 첫 문자가 알파벳인지 판별 
            if(str.length()>0 && Character.isLetter(str.charAt(0))) {
                str = str.substring(0,1).toUpperCase() + str.substring(1,str.length()).toLowerCase();
                answer += str;
            }
            else {
                str = str.toLowerCase();
                answer += str;
            }
            
            answer += " ";
        }
        
        //마지막 공백 제거
        return answer.substring(0,answer.length()-1);
    }
}