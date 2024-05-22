import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        // 문자배열 생성
        Character[] a = new Character[s.length()];
        
        // a에 저장
        for (int i = 0;i<s.length();i++) {
            a[i] = s.charAt(i);
        }
        
        // 내림차순 sort
        Arrays.sort(a,Collections.reverseOrder());
        
        // StringBuilder b 생성
        StringBuilder b = new StringBuilder(s.length());
        
        // b에 저장
        for (char c:a) {
            b.append(c);
        }
        
        // 문자열로 변환
        return b.toString();
    }
}