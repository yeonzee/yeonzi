import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int num : tangerine) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (v1, v2) -> (map.get(v2).compareTo(map.get(v1))));
        
        int sum=0;
        for (int a : list) {
           sum += map.get(a);
            answer++;
            if (sum>=k) {
                break;
            }
        }

        return answer;
    }
}