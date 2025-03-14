import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] temp:clothes) {
            map.put(temp[1], map.getOrDefault(temp[1],0)+1);  
        }
        
        for(String str:map.keySet()) {
            answer *= map.get(str)+1;
        }
        
        //아무것도 안입는 경우 제외
        return answer-1;
    }
}