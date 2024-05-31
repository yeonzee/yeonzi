import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        HashSet<Character> skipSet = new HashSet<>();
        
        // skip 문자열의 각 문자를 HashSet에 추가
        for (char ch : skip.toCharArray()) {
            skipSet.add(ch);
        }
        
        for (char ch : s.toCharArray()) {
            char newChar = ch;
            int steps = 0;
            
            while (steps < index) {
                newChar++;
                if (newChar > 'z') {
                    newChar = 'a';
                }
                if (!skipSet.contains(newChar)) {
                    steps++;
                }
            }
            answer.append(newChar);
        }
        
        return answer.toString();
    }
}
