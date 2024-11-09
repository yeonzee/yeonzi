import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=yellow; i++) {
            //정수일경우만 고려
            if(yellow%i==0) {
                int j = yellow/i;
                
                if((i*2+j*2)+4 == brown) {
                    answer[0] = Math.max(i,j)+2;
                    answer[1] = Math.min(i,j)+2;
                    return answer;
                }
            }
            
            
        }
        return answer;
    }
}