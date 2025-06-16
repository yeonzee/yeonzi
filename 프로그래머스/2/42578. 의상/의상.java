import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String[] temp:clothes) {
            map.put(temp[1], map.getOrDefault(temp[1],0)+1);
        }
        
        for(String key:map.keySet()) {
            answer *= map.get(key)+1;
        }
        
        return answer-1;
    }
}

/*
y_h, g_t, x
b_s, x
-> 6가지 조합 나옴
-> 아무것도 안입는 경우(x,x) 제외
*/