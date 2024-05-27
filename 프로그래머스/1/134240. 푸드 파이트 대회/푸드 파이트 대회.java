import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        for (int i=1;i<food.length;i++) {
            if(food[i]>1) {
                sb.append(String.valueOf(i).repeat(food[i]/2));
            }
            else {
                continue;
            }
        }
        
        String[] str = new String[sb.length()];
        for (int j = 0; j < sb.length(); j++) {
            str[j] = String.valueOf(sb.charAt(j));
        }
        
        
        
        String result = sb.toString() + "0";
        
        Arrays.sort(str, Collections.reverseOrder());
        
        for (String s : str) {
            result += s;
        }
        
        return result;
    }
}