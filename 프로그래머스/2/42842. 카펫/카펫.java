//시간 효율성을 위해 for문은 1개만
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=3; i<brown; i++) {
            
            //나누어 딱 떨어지는 것만 계산
            if((brown+yellow)%i==0) {
                int j=(brown+yellow)/i;
                
                if((i-2)*2+(j-2)*2+4 == brown) {
                answer[0] = Math.max(i,j);
                answer[1] = Math.min(i,j);
            }
            }
            
            
        }
        return answer;
    }
}