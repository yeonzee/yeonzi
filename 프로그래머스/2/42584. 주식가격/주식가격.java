import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
            int temp = 0;
            for(int j=i+1; j<prices.length; j++) {
                if(prices[i] <= prices[j]) {  //뒷값보다 작거나 같다면
                    temp++;
                }
                else {  //더 크다면 
                    temp++;
                    break;
                }
            }
            answer[i] = temp;
        }
        return answer;
    }
}