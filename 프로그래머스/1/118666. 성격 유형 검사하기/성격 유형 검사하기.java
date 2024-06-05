import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<survey.length;i++) {
            int n = choices[i];
            if(n < 4) { //n = 1,2,3
                char c = survey[i].charAt(0);
                map.put(c, map.getOrDefault(c,0)+4-n);
            }
            else if (n > 4) { //n = 5,6,7
                char c = survey[i].charAt(1);
                map.put(c,map.getOrDefault(c,0)+n-4);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if (map.getOrDefault('R',0) >= map.getOrDefault('T',0)) {
            sb.append('R');
        }
        else {
            sb.append('T');
        }
        
        if (map.getOrDefault('C',0) >= map.getOrDefault('F',0)) {
            sb.append('C');
        }
        else {
            sb.append('F');
        }
        if (map.getOrDefault('J',0) >= map.getOrDefault('M',0)) {
            sb.append('J');
        }
        else {
            sb.append('M');
        }
        if (map.getOrDefault('A',0) >= map.getOrDefault('N',0)) {
            sb.append('A');
        }
        else {
            sb.append('N');
        }
        
        
        return sb.toString();
    }
}