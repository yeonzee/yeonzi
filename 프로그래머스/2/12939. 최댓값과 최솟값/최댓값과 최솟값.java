import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] temp = s.split(" ");
        int[] num = new int[temp.length];
        
        for(int i=0; i<temp.length; i++) {
            num[i] = Integer.parseInt(temp[i]);
        } 
        
        //정렬
        Arrays.sort(num);
        
        answer = String.valueOf(num[0]) + " " + String.valueOf(num[num.length-1]);
        
        return answer;
    }
}