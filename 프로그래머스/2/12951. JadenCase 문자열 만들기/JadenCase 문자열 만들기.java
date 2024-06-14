//내가 푼 거
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        //맨 뒤 공백까지 추가하여 split
        String[] ss = s.split(" ", -1); 

        for (int i = 0; i < ss.length; i++) {
            //문자열 하나가 공백이라면 공백 추가
            if (ss[i].isEmpty()) {
                answer.append(" ");
            } else {
                answer.append(ss[i].substring(0, 1).toUpperCase());
                answer.append(ss[i].substring(1).toLowerCase());
                answer.append(" ");
            }
        }

        
        if (s.substring(s.length()-1,s.length()).isEmpty()) {
            return answer.toString();
        }

        return answer.substring(0,answer.length()-1).toString();
    }
}
