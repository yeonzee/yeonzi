import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        
        // participant map에 넣기
        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        // completion에 있는 선수 개수 빼기
        for (String s : completion) {
            map.put(s, map.get(s) - 1);
        }
        
        // 완주하지 못한 참가자 
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }
        
        return answer; 
    }
}