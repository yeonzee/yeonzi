// 1. n을 문자열로 변경
// 2. 문자배열로 저장
// 3. sort 하여 내림차순 배열
// 4. 정리된 배열을 다시 문자열로 변환
// 5. long으로 변환

import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = String.valueOf(n);
        
        Character[] a = new Character[str.length()];
        
        for (int i=0;i<str.length();i++) {
            a[i] = str.charAt(i);
        }
        
        Arrays.sort(a,Collections.reverseOrder());
        
        StringBuilder b = new StringBuilder(a.length);
        for (char c:a) {
            b.append(c);
        }
        
        return Long.parseLong(b.toString());
    }
}