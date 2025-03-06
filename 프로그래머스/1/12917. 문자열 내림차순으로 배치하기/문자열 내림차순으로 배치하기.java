import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
    
        //배열로 만들기
        Character[] list = new Character[s.length()];
        for(int i=0; i<list.length; i++) {
            list[i] = s.charAt(i);
        }
        
        //내림차순 정렬
        Arrays.sort(list, Collections.reverseOrder());
        
        for(int i=0; i<list.length; i++) {
            answer += list[i].toString();
        }
        
        return answer;
    }
}