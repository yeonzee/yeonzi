import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        //참여자 다 넣기
        for(String s:participant) {
            map.put(s, map.getOrDefault(s,0)+1);
        }
        
        //완주자 빼기
        for(String s:completion) {
            map.put(s, map.getOrDefault(s,0)-1);
        }
        
        //0 이상이라면 완주하지 못했다는 뜻
        for(String k:map.keySet()) {
            if(map.get(k) > 0) {
                answer = k;
            }
        }
        return answer;
    }
}