import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = n+1;
        
        String bi_n = Integer.toBinaryString(n);
        int count_n = 0;
        for(int i=0; i<bi_n.length(); i++) {
            if(bi_n.charAt(i) == '1') {
                count_n++;
            }
        }
        
        while(true) {
            String bi = Integer.toBinaryString(answer);
            int count_bi = 0;
            for(int j=0; j<bi.length(); j++) {
                if(bi.charAt(j) == '1') {
                    count_bi++;
                }
            }
            
            if(count_n == count_bi) {
                break;
            }
            
            answer++;
        }
        
        return answer;
    }
}