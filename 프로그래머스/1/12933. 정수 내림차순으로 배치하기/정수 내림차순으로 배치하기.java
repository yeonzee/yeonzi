/*
String으로 변경
배열에 임시 저장 후 내림차순 정렬
Long형으로 변환
*/
import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String str = String.valueOf(n);
        int len = str.length();
        Character[] temp = new Character[len];
        
        for(int i=0; i<len; i++) {
            temp[i] = str.charAt(i);
        }
        
        //내림차순 정렬
        Arrays.sort(temp, Collections.reverseOrder());
        
        String result = "";
        for(int j=0; j<len; j++) {
            result += temp[j];
        }
        
        return Long.parseLong(result);
    }
}