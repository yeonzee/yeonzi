import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i=1;i<food.length;i++) {
            if (food[i] > 1) {
                sb.append(String.valueOf(i).repeat(food[i] / 2));
            }
            else {
                continue;
            }
        }  
        answer = sb + "0";
        return answer.toString() + sb.reverse().toString();
    }
}