//n에 해당하는 문자 뽑아내서 앞에 붙인 후 정렬

import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        for (int i=0;i<strings.length;i++) {
            answer[i] = strings[i].charAt(n) + strings[i];
        }
        
        Arrays.sort(answer);
        
        int idx = 0;
        for (String a:answer) {
            answer[idx] = a.substring(1);
            idx++;
        }
        
        return answer;
    }
}