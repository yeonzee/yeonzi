//조건: 마지막 알파벳으로 시작 + 이전에 나오지 않았던 단어
import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        
        for(int i=0; i<words.length-1; i++) {
            String now = words[i];
            String next = words[i+1];
            
            //끝말잇기 실패
            if(now.charAt(now.length()-1) != next.charAt(0)) {
                return new int[]{ (i+1) % n + 1, (i+1) / n + 1 };
            }
            
            //이미 나온 단어면 실패
            for(int j=0; j<=i; j++) {
                if(next.equals(words[j])) {
                    return new int[]{ (i+1) % n + 1, (i+1) / n + 1 };
                }
            }
        }

        
        return answer;
    }
}