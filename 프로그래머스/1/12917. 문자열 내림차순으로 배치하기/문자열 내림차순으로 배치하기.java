import java.util.*;
class Solution {
    public String solution(String s) {
        Character[] chars = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }

        // 배열을 내림차순으로 정렬
        Arrays.sort(chars, Collections.reverseOrder());

        // 정렬된 배열을 다시 문자열로 변환
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) {
            sb.append(c);
        }

        return sb.toString();
    }
}