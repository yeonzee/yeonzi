import java.util.*;
class Solution {
    public String solution(int num) {
        String answer = "";
        
        //짝수라면
        if(num % 2 == 0) {
            answer = "Even";
        }
        //홀수라면
        else {
            answer = "Odd";
        }
        return answer;
    }
}