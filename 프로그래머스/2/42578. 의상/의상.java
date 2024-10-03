//해시맵 사용
import java.util.*;
class Solution {
    public int solution(String[][] clotheas) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<clotheas.length; i++) {
            map.put(clotheas[i][1], map.getOrDefault(clotheas[i][1],0)+1);
        }
        
        //조합
        for(String str:map.keySet()) {
            answer *= map.get(str)+1;
        }
        return answer-1;
    }
}