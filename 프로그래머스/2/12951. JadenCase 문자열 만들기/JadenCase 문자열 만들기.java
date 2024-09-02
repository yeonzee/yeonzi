import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
        for(int i=0; i<arr.length; i++) {
            //문자열이 공백이라면 공백 추가
            if(arr[i].length()==0) {
                answer += " ";
            }
            
            else {  //문자가 있다면
                answer += arr[i].substring(0,1).toUpperCase();
                answer += arr[i].substring(1,arr[i].length()).toLowerCase();
                answer += " ";
            }
        }
        
        //입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
        if(s.substring(s.length()-1, s.length()).equals(" ")) {
            return answer;
        }
        
        //맨 마지막 " " 제거하고 반환
        return answer.substring(0, answer.length()-1);
    }
}