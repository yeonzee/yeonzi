//복습_내가 품
import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int i=1;i<brown;i++) {
            for(int j=1;j<brown;j++) {
                if(i*j == yellow && (i*2 + j*2) + 4 == brown) {
                    answer[0] = Math.max(i,j)+2;
                    answer[1] = Math.min(i,j)+2;
                    break;
                }
            }
        }
        return answer;
    }
}