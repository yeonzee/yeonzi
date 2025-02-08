import java.util.*;
class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        //정렬
        Arrays.sort(words);
        
        int[] count = new int[words.length];
        
        for(int i=0; i<words.length-1; i++) {
            String now = words[i];
            String next = words[i+1];
            
            //문자열 중 더 작은 길이
            int len = Math.min(now.length(), next.length());

            //같은 알파벳 개수
            int cnt = 0;
            for(int j=0; j<len; j++) {
                //같지 않은 알파벳이 등장한다면 break
                if(now.charAt(j) != next.charAt(j)) {
                    break;
                }
                cnt++;
            }
            
            //짧은 문자열의 길이와 겹치는 알파벳의 갯수가 같다면 앞의 문자열은 뒷 문자열의 접두사이다.
            if(len == cnt) {
                count[i] = Math.max(count[i],cnt);
            }
            else {
                count[i] = Math.max(count[i],cnt+1);
            }
            
            //뒷 문자열은 겹치는 부분+1을 해줘야 단어
            count[i+1] = Math.max(count[i+1],cnt+1);
        }
        
        //answer에 더하기
        for(int i=0; i<count.length; i++) {
            answer += count[i];
        }
        
        return answer;
    }
}