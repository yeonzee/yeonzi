import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1; i<=yellow; i++) {
            //딱 나누어 떨어질때만
            if(yellow%i == 0) {
                int j = yellow/i;
                
                if(i*2 + j*2 + 4 == brown) {
                answer[0] = i+2;
                answer[1] = j+2;
                }
            }
            
            
        }
        
        
        return answer;
    }
}